import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {


  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';

    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }



 /*  constructor(private authService: AuthService, public progressBar: ProgressBarService,
    private alertService: AlertService) { } */

  ngOnInit(): void {
  }

  /* onSubmit(f: NgForm) {
    this.alertService.info('Working on sending email');
    this.progressBar.startLoading();
    const resetPasswordObserver = {
      next: x => {
        this.progressBar.setSuccess();
        this.alertService.success('Check email to change password');
        console.log('Check email to change password');
        this.progressBar.completeLoading();
      },
      error: err => {
        this.progressBar.setError();
        console.log(err);
        this.alertService.danger('Unable to send email');
        this.progressBar.completeLoading();
      }
    };
    this.authService.resetPassword(f.value).subscribe(resetPasswordObserver);
  }
 */
}
