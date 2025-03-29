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