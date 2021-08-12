import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Project } from "../project";
import { environment } from "src/environments/environment";
import { Freelancer } from "../freelancer/freelancer";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(`${this.apiServerUrl}/Project/projects`);
  }

  public addProject(project: Project | null): Observable<Project> {
    console.log("Here agaaaaaaaaain");
    console.log(project);
    return this.http.post<Project>(`${this.apiServerUrl}/Project/add`, project);
  }

  public updateProject(project: Project | null): Observable<Project> {
    return this.http.put<Project>(`${this.apiServerUrl}/Project/update`, project);
  }

  public findFreelancer(freelancer_id: number | undefined): Observable<Freelancer> {
    return this.http.get<Freelancer>(`${this.apiServerUrl}/Freelancer/find/${freelancer_id}`);
  }

  public deleteProject(projectId: number | undefined): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/Project/delete/${projectId}`);
  }
}