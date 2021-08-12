import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Project } from './project';
import { ProjectService } from './project.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Freelancer } from '../freelancer/freelancer';
import { FreelancerService } from '../freelancer/freelancer.service';
import { Employer } from '../employer/employer';
import { EmployerService } from '../employer/employer.service';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  public freelancers: Freelancer[] = [];
  public projects: Project[] = [];
  public employers: Employer[] = [];
  public editProject: Project | null = null;
  public deleteProject: Project | null = null;
  public freelancer: Freelancer | null = null;
  public employer: Employer | null = null;
  public project: Project | null = null;

  constructor(private router: Router, private projectService: ProjectService, private freelancerService: FreelancerService, private employerService: EmployerService) { }

  ngOnInit() {
    this.getProjects();
    this.getFreelancers();
    this.getEmployers();
  }

  public getEmployers(): void {
    this.employerService.getEmployers().subscribe(
      (response: Employer[]) => {
        this.employers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public getFreelancers(): void {
    this.freelancerService.getFreelancers().subscribe(
      (response: Freelancer[]) => {
        this.freelancers = response;
        console.log(this.freelancers);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public getProjects(): void {
    this.projectService.getProjects().subscribe(
      (response: Project[]) => {
        this.projects = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public findFreelancer(id: string) {
    for (let i = 0; i < this.freelancers.length; i++) {
      if (this.freelancers[i].id.toString() === id) {
        this.freelancer = this.freelancers[i];
      }
    }
  }

  public findEmployer(id: string) {
    for (let i = 0; i < this.employers.length; i++) {
      if (this.employers[i].id.toString() === id) {
        this.employer = this.employers[i];
      }
    }
  }

  public onAddProject(addForm: NgForm): void {
    document?.getElementById('add-project-form')?.click();
    var fId = addForm.value.freelancer;
    var eId = addForm.value.employer;
    console.log(addForm.value);
    this.findFreelancer(fId);
    this.findEmployer(eId);
    // delete addForm.value.freelancer;
    addForm.value.freelancer = this.freelancer;

    // delete addForm.value.employer;
    addForm.value.employer = this.employer;
    console.log("HERE I AM");
    console.log(addForm.value);

    this.projectService.addProject(addForm.value).subscribe(
      (response: Project) => {
        console.log(response);
        this.project = response;
        this.getProjects();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateProject(project: Project | null, editForm: NgForm): void {
    console.log(project);
    this.projectService.updateProject(project).subscribe(
      (response: Project) => {
        console.log(response);
        this.getProjects();
        document?.getElementById('edit-project-form-close')?.click();

      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        editForm.reset();
      }
    );
  }

  public onDeleteProject(projectId: number | undefined): void {
    this.projectService.deleteProject(this.deleteProject?.id).subscribe(
      (response: void) => {
        console.log(response);
        this.getProjects();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  public onOpenModal(project: Project | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addProjectModal');
    }
    if (mode === 'edit') {
      this.editProject = project;
      button.setAttribute('data-target', '#updateProjectModal');
    }
    if (mode === 'delete') {
      this.deleteProject = project;
      console.log(this.deleteProject);
      button.setAttribute('data-target', '#deleteProjectModal');
    }
    container?.appendChild(button);
    button.click();
  }

}