import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: string = "";
  public password: string = "";
  message: any

  constructor(private service: LoginService, private router: Router) { }

  ngOnInit() {
  }

  doLogin() {
      sessionStorage.setItem('username', this.username);
    this.router.navigate(["/project"]);
    
  }

}