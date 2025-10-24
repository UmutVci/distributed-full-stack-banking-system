import express from "express";
import dotenv from "dotenv";
import { authenticateToken } from "./middlewares/auth.js";
import { apiLimiter } from "./middlewares/rateLimit.js";
import { corsMiddleware } from "./middlewares/cors.js";
import proxyRoutes from "./routes/proxy.js";


dotenv.config();

const app = express();
app.use(express.json());
app.use(corsMiddleware);
app.use(apiLimiter);

app.use(authenticateToken);
app.get("/health", (req, res) => res.json({ status: "ok" }));

app.use("/api/v1", proxyRoutes);

app.get("/secure", authenticateToken, (req, res) => {
    res.json({ message: "Access granted", user: req.user });
});

const port = process.env.PORT || 8080;
app.listen(port, () => {
    console.log(`API Gateway running on port ${port}`);
});
