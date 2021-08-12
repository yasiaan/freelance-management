import { Component, OnInit } from '@angular/core';
import { Employer } from '../employer/employer';
import { EmployerService } from './employer.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './employer.component.html',
  styleUrls: ['./employer.component.css']
})
export class EmployerComponent implements OnInit {

  public employers: Employer[] = [];
  public editEmployer: Employer | null = null;
  public deleteEmployer: Employer | null = null;

  constructor(private employerService: EmployerService) { }

  ngOnInit() {
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

  public onAddEmployer(addForm: NgForm): void {
    document?.getElementById('add-employee-form')?.click();
    this.employerService.addEmployer(addForm.value).subscribe(
      (response: Employer) => {
        console.log(response);
        this.getEmployers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmployer(employer: Employer | null): void {
    this.employerService.updateEmployer(employer).subscribe(
      (response: Employer) => {
        console.log(response);
        this.getEmployers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmloyer(employerId: number | undefined): void {
    this.employerService.deleteEmployer(employerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEmployers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(employer: Employer | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployerModal');
    }
    if (mode === 'edit') {
      this.editEmployer = employer;
      button.setAttribute('data-target', '#updateEmployerModal');
    }
    if (mode === 'delete') {
      this.deleteEmployer = employer;
      button.setAttribute('data-target', '#deleteEmployerModal');
    }
    container?.appendChild(button);
    button.click();
  }

}