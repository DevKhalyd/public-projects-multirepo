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
 * 
 * These values could be used to identify the type of message being sent or received.
 */
enum MessageType {
    Create,
    Join,
    // Make a move if the game is in progress
    Move,
    // Get or Send the current game state
    State,
    Error
}

/**
 * Creates a new game and sends back the game and player IDs.
 */
function createGameHandler(ws: WebSocket) {
    const gameId = uuidv4();
    const playerId = uuidv4();
    const game = createGame(gameId);
    game.playersId.first = playerId;

    ws.send(JSON.stringify({ type: MessageType.Create, payload: { gameId, playerId } }));
}

/**
 * Joins a player to an existing game and assigns them a player ID.
 * If the game is full, an error message is sent back.
 */
function joinGameHandler(ws: WebSocket, gameId: string) {
    const playerId = uuidv4();
    const gameState = joinGame(gameId, playerId);
    if (gameState) {
        ws.send(JSON.stringify({ type: MessageType.Join, payload: gameState }));
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
                client.send(JSON.stringify({ type: MessageType.Move, payload: result }));
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
                    case MessageType.Create:
                        createGameHandler(ws);
                        break;
                    case MessageType.Join:
                        joinGameHandler(ws, payload.gameId);
                        break;
                    case MessageType.Move:
                        makeMoveHandler(ws, wss, payload);
                        break;
                    case MessageType.State:
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