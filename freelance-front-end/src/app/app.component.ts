import { Component, OnInit } from '@angular/core';
import { Freelancer } from './freelancer/freelancer';
import { FreelancerService } from './freelancer/freelancer.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from './service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public freelancers: Freelancer[] = [];

  constructor(public loginService: AuthenticationService) { }

  ngOnInit() {
  }


}
