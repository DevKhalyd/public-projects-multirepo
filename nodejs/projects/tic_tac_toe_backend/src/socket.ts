/**
 * WebSocket setup for Tic Tac Toe.
 * 
 * Improvements:
 * 1. Document each function.
 * 2. Extract each switch case into a separate function.
 * 3. Use enums for message types for better readability.
 */

import { Server as HTTPServer } from "http";
import { WebSocketServer, WebSocket } from "ws";
import { v4 as uuidv4 } from "uuid";
import {
    createGame,
    joinGame,
    getGameState,
    makeMove,
    MoveError,
} from "./game";

/**
 * Enum representing WebSocket message types.
 */
enum MessageType {
    GameCreated,
    Joined,
    Update,
    Error,
    State,
}

/**
 * Creates a new game and sends back the game and player IDs.
 */
function createGameHandler(ws: WebSocket) {
    const gameId = uuidv4();
    const playerId = uuidv4();
    const game = createGame(gameId);
    game.playersId.first = playerId;

    ws.send(JSON.stringify({ type: MessageType.GameCreated, payload: { gameId, playerId } }));
}

/**
 * Joins a player to an existing game and assigns them a player ID.
 * If the game is full, an error message is sent back.
 */
function joinGameHandler(ws: WebSocket, gameId: string) {
    const playerId = uuidv4();
    const joined = joinGame(gameId, playerId);
    if (joined) {
        ws.send(JSON.stringify({ type: MessageType.Joined, payload: joined }));
    } else {
        ws.send(JSON.stringify({ type: MessageType.Error, payload: "Unable to join game" }));
    }
}

/**
 * Makes a move and broadcasts the updated game state.
 */
function makeMoveHandler(ws: WebSocket, wss: WebSocketServer, payload: any) {
    const result = makeMove(payload.gameId, payload.playerId, payload.index);
    if (typeof result === "number") {
        ws.send(JSON.stringify({ type: MessageType.Error, payload: MoveError[result] }));
    } else {
        wss.clients.forEach((client) => {
            if (client.readyState === ws.OPEN) {
                client.send(JSON.stringify({ type: MessageType.Update, payload: result }));
            }
        });
    }
}

/**
 * Sends the current game state to the client.
 */
function getGameStateHandler(ws: WebSocket, payload: any) {
    const current = getGameState(payload.gameId);
    if (current) {
        ws.send(JSON.stringify({ type: MessageType.State, payload: current }));
    } else {
        ws.send(JSON.stringify({ type: MessageType.Error, payload: "Game not found" }));
    }
}

/**
 * Initializes the WebSocket server.
 */
export const setupWebSocket = (server: HTTPServer) => {
    const wss = new WebSocketServer({ server });

    wss.on("connection", (ws: WebSocket) => {
        console.log("Client connected");

        ws.on("message", (message: string) => {
            try {
                const data = JSON.parse(message);
                const { type, payload } = data;

                switch (type) {
                    case "create":
                        createGameHandler(ws);
                        break;
                    case "join":
                        joinGameHandler(ws, payload.gameId);
                        break;
                    case "move":
                        makeMoveHandler(ws, wss, payload);
                        break;
                    case "state":
                        getGameStateHandler(ws, payload);
                        break;
                    default:
                        ws.send(JSON.stringify({ type: MessageType.Error, payload: "Unknown event type" }));
                }
            } catch (e) {
                ws.send(JSON.stringify({ type: MessageType.Error, payload: "Invalid JSON format" }));
            }
        });

        ws.on("close", () => {
            console.log("Client disconnected");
        });
    });
};