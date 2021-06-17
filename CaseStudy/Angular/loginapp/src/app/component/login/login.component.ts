import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;         //hide password
  value = "";  //clear input

   //Add Snack Bar
   openSnackBar(message: string, action: string) {
    this._snackBar.open('Request Submitted', 'Logging in', {
      duration: 2000,
    });
  }


  credentials={
    userName:"",
    password:"",
 
  }

  constructor(private loginService:LoginService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  OnSubmit(){
    console.log("form is submitted")
    if((this.credentials.userName!='' && this.credentials.password!='') && (this.credentials.userName!=null && this.credentials.password!=null))
    {
         //genreate token
         this.loginService.generateToken(this.credentials).subscribe(
           (response:any)=>{
              console.log(response.token);
              this.loginService.loginUser(response.token);
              window.location.href="/dashboard";
           },
           error=>{
            console.log(error);

           }
         )

    }else{
      console.log("Fields are empty !!")
    }
  }


}
