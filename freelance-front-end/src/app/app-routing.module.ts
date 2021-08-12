import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FreelancerComponent } from './freelancer/freelancer.component';
import { EmployerComponent } from './employer/employer.component';
import { ProjectComponent } from './project/project.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';

const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'employer', component: EmployerComponent, canActivate: [AuthGaurdService] },
  { path: 'freelancer', component: FreelancerComponent, canActivate: [AuthGaurdService] },
  { path: 'project', component: ProjectComponent, canActivate: [AuthGaurdService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [EmployerComponent, FreelancerComponent, ProjectComponent, AppComponent, LoginComponent]