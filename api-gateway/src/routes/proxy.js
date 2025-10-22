import express from "express";
import axios from "axios";

const router = express.Router();

const ACCOUNT_SERVICE = `http://${process.env.ACCOUNT_SERVICE_HOST}:${process.env.ACCOUNT_SERVICE_PORT}`;
const TRANSACTION_SERVICE = `http://${process.env.TRANSACTION_SERVICE_HOST}:${process.env.TRANSACTION_SERVICE_PORT}`;

router.get("/accounts/:id/balance", async (req, res) => {
    try {
        const resp = await axios.get(`${ACCOUNT_SERVICE}/api/v1/accounts/${req.params.id}/balance`);
        res.json(resp.data);
    } catch (err) {
        res.status(err.response?.status || 500).json({ message: err.message });
    }
});

router.post("/transactions/transfer", async (req, res) => {
    try {
        const resp = await axios.post(`${TRANSACTION_SERVICE}/api/v1/transactions/transfer`, req.body);
        res.json(resp.data);
    } catch (err) {
        res.status(err.response?.status || 500).json({ message: err.message });
    }
});

router.post("/auth/register", async (req, res) => {
    try {
        const response = await axios.post(`${ACCOUNT_SERVICE}/api/v1/auth/register`, req.body);
        res.status(response.status).json(response.data);
    } catch (err) {
        res.status(err.response?.status || 500).json({
            message: err.response?.data?.message || err.message,
        });
    }
});

router.post("/auth/login", async (req, res) => {
    try {
        const response = await axios.post(`${ACCOUNT_SERVICE}/api/v1/auth/login`, req.body);
        res.status(response.status).json(response.data);
    } catch (err) {
        res.status(err.response?.status || 500).json({
            message: err.response?.data?.message || err.message,
        });
    }
});

export default router;
