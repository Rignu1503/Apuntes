import { AppDataSource } from "../config/connection-db"
import { TeamLeader } from "../entity/team-leader"


const teamLiderRepository = AppDataSource.getRepository(TeamLeader);

export async function getAll(req: Request, res: Response) {
    
    try {
        res.json({
            data: await teamLiderRepository.find()
        })
    } catch (error) {
        
        error: error
    }

}