import { Project } from "./project";
import { Freelancer } from "./freelancer/freelancer";

export interface Proposals {
    id: number;
    description: string;
    dateAjout: Date;
    project: Project;
    freelancer: Freelancer;
}

