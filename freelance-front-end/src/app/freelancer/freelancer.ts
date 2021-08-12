import { Project } from "../project";
import { Proposals } from "../proposals";

export interface Freelancer {
    id: number;
    nom: string;
    prenom: string;
    email: string;
    phone: string;
    freelancerCode: string;
    skills: string;
    imgurl: string;
    bids: number;
    project: Project;
    proposals: Proposals;
}