import express, { Request, Response } from "express";
import { AppDataSource } from "./config/connection-db";

const app = express();
app.use(express.json());

app.get("/", (req: Request, res: Response) => {
    res.json({ message: "Hello World!" });
});

AppDataSource.initialize()
    .then(() => {
        console.log("Database connected");

        app.listen(7000, () => {
            console.log("Server is running on port 7000");
        }); // <-- Cierre de app.listen() dentro del then
    })
    .catch((err) => {
        console.log("Error while connecting to the database", err);
    });
