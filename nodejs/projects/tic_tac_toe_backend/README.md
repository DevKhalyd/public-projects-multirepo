# Run Server

```bash
# Run the app in dev mode
npm run dev
```

# Overview

express → Handles REST API

ws → WebSockets for real-time communication

cors → Allows cross-origin requests (important for frontend)

typescript & ts-node → TypeScript setup

nodemon → Auto-restarts the server on file changes

# Why Can We Run server.ts directly?

**ts-node:** This package enables Node.js to execute TypeScript files directly.

When you run:

```bash
npx ts-node src/server.ts
```

It compiles and runs server.ts in one step, without generating .js files.

nodemon with ts-node (for development)

nodemon watches for changes and restarts the server automatically.

Our script:

```bash
"dev": "nodemon src/server.ts"
```

runs server.ts directly using ts-node, bypassing the manual build step.

# Postman

WebSockets Reference: https://learning.postman.com/docs/sending-requests/websocket/work-with-websocket-messages/

## Game Info (Example)

**The game to join:**

"gameId": "4166b436-8bda-42d3-9df8-b2317434e649"

**Players**

"playerIdOne-X": "b06ffb0b-a556-4123-80a9-368d338431b7"
"playerIdTwo-O": "2c1fcf1a-9471-457a-8bd7-fa60c58aca92"

The first turn is always for X

**Final Response**

```json
{
    "type": 2,
    "payload": {
        "id": "4166b436-8bda-42d3-9df8-b2317434e649",
        "board": [
            "X",
            "X",
            "X",
            null,
            "O",
            "O",
            null,
            null,
            null
        ],
        "playersId": {
            "first": "b06ffb0b-a556-4123-80a9-368d338431b7",
            "second": "2c1fcf1a-9471-457a-8bd7-fa60c58aca92"
        },
        "currentTurn": "X",
        "winner": "X" // This field comes null until there is a winner
    }
}
```

# ✅ Tic-Tac-Toe WebSocket Test (Postman)

## 🔌 Connect to WebSocket
URL: `ws://localhost:3000`

---

## 🟢 1. Create Game

```json
{
  "type": "create"
}
```

Expected response:

```json
{
  "type": 0,
  "payload": {
    "gameId": "your-game-id",
    "playerId": "player1-id"
  }
}
```

---

## 🟡 2. Join Game (in a second WebSocket tab)

```json
{
  "type": "join",
  "payload": {
    "gameId": "your-game-id",
  }
}
```

---

## 🎮 3. Play a Draw Game (send these moves one by one)

| Turn | Player | Index |
|------|--------|--------|
| 1    | X      | 0     |
| 2    | O      | 1     |
| 3    | X      | 2     |
| 4    | O      | 4     |
| 5    | X      | 3     |
| 6    | O      | 5     |
| 7    | X      | 7     |
| 8    | O      | 6     |
| 9    | X      | 8     |

Use this format for each move:

```json
{
  "type": "move",
  "payload": {
    "gameId": "your-game-id",
    "playerId": "player-id",
    "index": "${boardIndex}"
  }
}
```

---

## 🧪 4. Final Response (after move 9)

```json
{
  "type": 2,
  "payload": {
    "winner": "draw",
    ...
  }
}
```

---

## 🔄 5. Check Game State

```json
{
  "type": "state",
  "payload": {
    "gameId": "your-game-id"
  }
}
```

# Next Steps

- Support more game rooms