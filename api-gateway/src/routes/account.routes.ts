import express, { Router } from 'express';
import {getBalance, updateBalance} from '../controllers/account.controller.js';
import axios from "axios";

const router = express.Router();

export const accountRouter = Router();


accountRouter.get('/:id/balance', getBalance);
accountRouter.post('/balance', updateBalance);


export default router;
