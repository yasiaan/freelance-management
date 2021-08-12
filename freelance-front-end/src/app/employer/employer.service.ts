import { Injectable } from '@angular/core';
import { Employer } from "../employer/employer";
import { environment } from "src/environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getEmployers(): Observable<Employer[]> {
    return this.http.get<Employer[]>(`${this.apiServerUrl}/Employer/employers`);
  }

  public addEmployer(employer: Employer | null): Observable<Employer> {
    return this.http.post<Employer>(`${this.apiServerUrl}/Employer/add`, employer);
  }

  public updateEmployer(employer: Employer | null): Observable<Employer> {
    return this.http.put<Employer>(`${this.apiServerUrl}/Employer/update`, employer);
  }

  public deleteEmployer(employerId: number | undefined): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/Employer/delete/${employerId}`);
  }
}
