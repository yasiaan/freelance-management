import { Injectable } from '@angular/core';
import { environment } from "src/environments/environment";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    login(username: string, password: string) {
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
        return this.http.get(this.apiServerUrl, { headers, responseType: 'text' as 'json' })
    }

    getUsers() {
        let username = 'zouzou'
        let password = 'freelancer1'
        const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
        return this.http.get(this.apiServerUrl, { headers });
    }
}