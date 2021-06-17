import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChangePasswordComponent } from './component/change-password/change-password.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { ResetPasswordComponent } from './component/reset-password/reset-password.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
 {path:"", component: HomeComponent, pathMatch:"full"},
 {path:"home", component: HomeComponent, pathMatch:"full"},
 {path:"login", component: LoginComponent, pathMatch:"full"},
 {path:"changepassword", component: ChangePasswordComponent, pathMatch:"full"},
 {path:"resetpassword", component: ResetPasswordComponent, pathMatch:"full"},
 {path:"dashboard", component: DashboardComponent, 
     pathMatch:"full", canActivate: [AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
