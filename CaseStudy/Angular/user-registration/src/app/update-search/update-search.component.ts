import { Component, OnInit , Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';

export interface UsersData {
  name: string;
  id: number;
  email:string,
  mobile:number,
  password:string
}

@Component({
  selector: 'app-update-search',
  templateUrl: './update-search.component.html',
  styleUrls: ['./update-search.component.css']
})
export class UpdateSearchComponent implements OnInit {

  action!: string;
  local_data:any;

  constructor(@Inject(MAT_DIALOG_DATA) public data:UsersData, private service: UserRegistrationService,  public dialogRef:MatDialogRef<UpdateSearchComponent>) { 

    console.log(data);
    this.local_data = {...data};
    this.action = this.local_data.action;
  }



  ngOnInit(): void {
  }
user!: User[];
  userToUpdate = {
    id:"",
    username:"",
    password:"",
    email:"",
    mobile: ""
    
  };

edit(user:any){
this.userToUpdate = user;
}

updateUser(){
  this.service.updateUser(this.userToUpdate).subscribe(
    (resp)=> {
      console.log(resp)
    },
    (err)=>{
      console.log(err);
    }
  )
}

/* doAction(){
  this.dialogRef.close({event:this.action,data:this.local_data});
}

closeDialog(){
  this.dialogRef.close({event:'Cancel'});
} */


}
