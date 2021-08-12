import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Freelancer } from "./freelancer";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FreelancerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getFreelancers(): Observable<Freelancer[]> {
    return this.http.get<Freelancer[]>(`${this.apiServerUrl}/Freelancer/freelancers`);
  }

  public addFreelancer(freelancer: Freelancer | null): Observable<Freelancer> {
    console.log(freelancer);
    return this.http.post<Freelancer>(`${this.apiServerUrl}/Freelancer/add`, freelancer);
  }

  public updateFreelancer(freelancer: Freelancer | null): Observable<Freelancer> {
    return this.http.put<Freelancer>(`${this.apiServerUrl}/Freelancer/update`, freelancer);
  }

  public deleteFreelancer(freelancerId: number | undefined): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/Freelancer/delete/${freelancerId}`);
  }
}