import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  value1 = "";  //clear input
  value2 = "";  //clear input
  value3 = "";  //clear input

  
  user: User=new User("","",0,"");
  message:any;

 //Add Snack Bar
 openSnackBar() {
  this._snackBar.open('Request Submitted', 'Logging in', {
    duration: 2000,
  });
}

// email validation

email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';

    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }



  constructor(private service:UserRegistrationService, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

   public registerNow(){
    let resp=this.service.doRegistration(this.user);
    resp.subscribe((data)=>this.message=data);
      }

  
}
