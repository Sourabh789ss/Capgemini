import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle'
import {MatCardModule} from '@angular/material/card';
import {FormsModule,ReactiveFormsModule  } from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { LoginService } from './login.service';
import { AuthGuard } from './services/auth.guard';
import { AuthInterceptor } from './services/auth.interceptor';
import { ChangePasswordComponent } from './component/change-password/change-password.component';
import { ResetPasswordComponent } from './component/reset-password/reset-password.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatMenuModule} from '@angular/material/menu';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    ChangePasswordComponent,
    ResetPasswordComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSlideToggleModule,
    MatCardModule,
    MatIconModule,
    ReactiveFormsModule  ,
    MatSnackBarModule,
    MatMenuModule,
    
  ],

  exports: [
    MatSlideToggleModule ,
    MatCardModule,
    MatIconModule,
    MatToolbarModule
],
  providers: [LoginService, AuthGuard, [{provide : HTTP_INTERCEPTORS, useClass : AuthInterceptor, multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }


