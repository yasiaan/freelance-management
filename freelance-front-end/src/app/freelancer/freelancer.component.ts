import { Component, OnInit } from '@angular/core';
import { Freelancer } from './freelancer';
import { Project } from '../project';
import { FreelancerService } from './freelancer.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './freelancer.component.html',
  styleUrls: ['./freelancer.component.css']
})
export class FreelancerComponent implements OnInit {

  public freelancers: Freelancer[] = [];
  public editFreelancer: Freelancer | null = null;
  public deleteFreelancer: Freelancer | null = null;

  constructor(private freelancerService: FreelancerService) { }

  ngOnInit() {
    this.getFreelancers();
  }

  public getFreelancers(): void {
    this.freelancerService.getFreelancers().subscribe(
      (response: Freelancer[]) => {
        this.freelancers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  public onAddFreelancer(addForm: NgForm): void {
    document?.getElementById('add-freelancer-form')?.click();
    this.freelancerService.addFreelancer(addForm.value).subscribe(
      (response: Freelancer) => {
        console.log(response);
        this.getFreelancers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateFreelancer(freelancer: Freelancer | null): void {
    this.freelancerService.updateFreelancer(freelancer).subscribe(
      (response: Freelancer) => {
        console.log(response);
        this.getFreelancers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteFreelancer(freelancerId: number | undefined): void {
    this.freelancerService.deleteFreelancer(freelancerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getFreelancers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(freelancer: Freelancer | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addFreelancerModal');
    }
    if (mode === 'edit') {
      this.editFreelancer = freelancer;
      button.setAttribute('data-target', '#updateFreelancerModal');
    }
    if (mode === 'delete') {
      this.deleteFreelancer = freelancer;
      button.setAttribute('data-target', '#deleteFreelancerModal');
    }
    container?.appendChild(button);
    button.click();
  }
}