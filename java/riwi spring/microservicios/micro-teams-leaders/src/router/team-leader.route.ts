import { Router } from "express";
import { getAll } from "../controller/team-leader.controller";

const TeamLeaderRouter = Router();

TeamLeaderRouter.get("/", getAll)

export default TeamLeaderRouter;