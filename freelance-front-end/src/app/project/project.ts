import { Employer } from "../employer/employer";
import { Freelancer } from "../freelancer/freelancer";


export interface Project {
    id: number;
    title: string;
    description: string;
    projectCode: string;
    employer: Employer;
    freelancer: Freelancer;
}
