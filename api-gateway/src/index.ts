import express from 'express';
import { errorHandler } from './middlewares/error.js';

const app = express();
app.use(express.json());


app.use(errorHandler);
app.listen(3000, () => console.log('Gateway running on port 8080'));