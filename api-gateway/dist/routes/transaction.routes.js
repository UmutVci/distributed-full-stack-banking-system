import { Router } from 'express';
import { transfer, history } from '../controllers/transaction.controller.js';
export const transactionRouter = Router();
transactionRouter.post('/transfer', transfer);
transactionRouter.get('/history/:accountId', history);
