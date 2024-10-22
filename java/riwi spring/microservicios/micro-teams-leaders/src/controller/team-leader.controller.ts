import { AppDataSource } from "../config/connection-db"
import { TeamLeader } from "../entity/team-leader"
import express, { Request, Response } from "express";




export const teamLiderRepository = AppDataSource.getRepository(TeamLeader);

export async function getAll(req: Request, res: Response) {
    
    try {
        res.json({
            data: await teamLiderRepository.find()
        })
    } catch (error) {
        
        res.json({
            error: error.message
        })
    }

}