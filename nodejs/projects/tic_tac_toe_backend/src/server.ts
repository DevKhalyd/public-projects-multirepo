import express from "express";
import cors from "cors";
import http from "http";
import { setupWebSocket } from "./socket";

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

app.get("/healthcheck", (_, res) => {
  res.status(200).json({ status: "ok", version: "1.0.0" });
});

app.get("/", (_, res) => {
  res.send("Welcome to the Tic Tac Toe API!");
});

const server = http.createServer(app);
setupWebSocket(server);

server.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}/healthcheck`);
});
