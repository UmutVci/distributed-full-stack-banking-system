import { Router } from 'express';
import axios from "axios";

export const router = Router();

const ACCOUNT_SERVICE = 'http://localhost:8081';

router.get('/health', (_req, res) => {
    res.json({ status: 'ok' });
});
