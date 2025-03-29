/**
 * Represents the two possible players in the game.
 * "X" and "O" are used as board symbols and to track turns.
 */
type Player = "X" | "O";

/**
 * Enum for handling move errors instead of raw strings.
 */
export enum MoveError {
    GameNotFound,
    GameAlreadyEnded,
    InvalidMove,
    CellAlreadyTaken,
    NotYourTurn
}

/**
 * Represents a Tic-Tac-Toe game instance.
 * 
 * Why use an interface instead of a class?
 * 
 * - Interfaces are **lighter** and **purely structural**, meaning they don't generate extra JavaScript code.  
 * - Our `Game` object is just **data**, and all logic is handled externally via functions.  
 * - Using an interface makes it **easier to extend** (e.g., adding a timed game mode).  
 * - If we needed behaviors like `game.makeMove()`, a **class** would be a better choice.  
 * 
 * Conclusion: Since `Game` is only a **data container**, an interface is the best choice for simplicity and flexibility.  
 */
interface Game {
    /** Unique identifier for the game. */
    id: string;

    /** 3x3 board represented as a 1D array. */
    board: (Player | undefined)[];

    /** Stores the IDs of the two players. */
    playersId: { first?: string; second?: string };

    /** Indicates which player's turn it is ("X" or "O"). */
    currentTurn: Player;

    /** Stores the winner when the game ends, otherwise undefined. */
    winner: Player | undefined;
}

/** In-memory storage for active games. */
const games = new Map<string, Game>();

/**
 * Creates a new Tic-Tac-Toe game.
 * 
 * @param id - The unique identifier for the new game.
 * @returns The newly created game object.
 */
export const createGame = (id: string): Game => {
    const newGame: Game = {
        id,
        board: Array(9).fill(undefined),
        playersId: {},
        currentTurn: "X", // Always starts with "X"
        winner: undefined,
    };
    games.set(id, newGame);
    return newGame;
};

/**
 * Allows a player to join an existing game.
 * A game must have two players.
 * 
 * @param gameId - The ID of the game to join.
 * @param playerId - The player's unique identifier.
 * 
 * @returns The updated game object or undefined if the game doesn't exist or is full.
 */
export const joinGame = (gameId: string, playerId: string): Game | undefined => {
    const game = games.get(gameId);

    // Check if the game exists or is full
    if (!game || Object.keys(game.playersId).length >= 2) return undefined;

    // Assign the player to the first available slot
    // keyof Game["playersId"] is either "first" | "second" or any value of playersId
    const playerRole: keyof Game["playersId"] = game.playersId.first ? "second" : "first";
    game.playersId[playerRole] = playerId;

    return game;
};

/**
 * Retrieves the current state of a game.
 * 
 * @param gameId - The ID of the game.
 * @returns The game object if found, otherwise undefined.
 */
export const getGameState = (gameId: string): Game | undefined => games.get(gameId);

/**
 * Handles a player's move in the game.
 * 
 * @param gameId - The ID of the game.
 * @param playerId - The ID of the player making the move.
 * @param index - The board index (0-8) where the move is placed.
 * 
 * @returns The updated game object or an error message if the move is invalid.
 */
export const makeMove = (gameId: string, playerId: string, index: number): Game | MoveError => {
    const game = games.get(gameId);

    // Instead of returning strings, use enum values for error messages
    if (!game) return MoveError.GameNotFound;
    if (game.winner) return MoveError.GameAlreadyEnded;
    if (index < 0 || index > 8) return MoveError.InvalidMove;
    if (game.board[index] !== undefined) return MoveError.CellAlreadyTaken;

    // Determine which player is making the move
    const currentPlayerId = game.currentTurn === "X" ? game.playersId.first : game.playersId.second;
    if (currentPlayerId !== playerId) return MoveError.NotYourTurn;

    // Place move
    game.board[index] = game.currentTurn;

    // The winningCombos array contains all possible ways a player can win in a 3x3 Tic-Tac-Toe board.
    // Each sub-array represents a set of three indices in the game.board array that form a row, column, or diagonal
    const winningCombos = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8],  // Rows
        [0, 3, 6], [1, 4, 7], [2, 5, 8],  // Columns
        [0, 4, 8], [2, 4, 6],             // Diagonals
    ];

    // Check for a winner
    for (const [a, b, c] of winningCombos) {
        //  Checks if all three positions contain the same player's symbol.
        if (game.board[a] && game.board[a] === game.board[b] && game.board[a] === game.board[c]) {
            game.winner = game.board[a]; // Declare winner
            return game;
        }
    }

    // Switch turn
    game.currentTurn = game.currentTurn === "X" ? "O" : "X";

    return game;
};
