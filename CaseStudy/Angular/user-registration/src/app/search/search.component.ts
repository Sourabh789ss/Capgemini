import { ViewChild } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MatDialog,} from '@angular/material/dialog';
import { UpdateSearchComponent, UsersData } from '../update-search/update-search.component';



@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})

export class SearchComponent implements OnInit {

  alert:boolean = false; 
  
  constructor(private service: UserRegistrationService,public modalService: NgbModal, public dialog : MatDialog  ) { }

  //users:any;
  email!: string;
  list:any;
  closeResult = '';
  //edit usr details
  userToUpdate = {
    id:"",
    username:"",
    password:"",
    email:"",
    mobile: ""
    
  };


  ELEMENT_DATA!: User[];
  ELEMENT_DATAS!: UsersData[];

  displayedColumns: string[] = [ 'id','name', 'password', 'email','mobile','Action'];
  dataSource = new MatTableDataSource<User>(this.ELEMENT_DATA);
  dataSources = new MatTableDataSource<UsersData>(this.ELEMENT_DATAS);

  //paginator
  @ViewChild(MatPaginator,{static: true}) paginator!: MatPaginator;

  //sorting
  @ViewChild(MatSort, {static: true}) sort!: MatSort;


  //apply filter
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  edit(User:any){
    this.userToUpdate = User;
    }

  public delteUser(id:any){
    let resp= this.service.deleteUser(id)
    resp.subscribe((datareq)=>{
      this.dataSource.data = datareq as User[]
      this.alert = true;
    }); 
   }
   closeAlert(){
     this.alert=false;
   }
   
   public findUserByEmailId(){
     let resp= this.service.getUserByEmail(this.email);
     resp.subscribe((datareq)=>this.dataSource.data=datareq as User[]);
    }
   
    
     ngOnInit() {

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort=this.sort;

       let resp=this.service.getUsers();
       resp.subscribe((datareq)=>this.dataSource.data=datareq as User[]);
     }

     //edit detail
     open(content: any) {
      this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
        this.closeResult = `Closed with: ${result}`;
      }, (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      });
    }
    
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return `with: ${reason}`;
      }
    }
     


    ///dialog box
    openDialog(){
     /*  obj.action=action; */
   let dialogRef = this.dialog.open(UpdateSearchComponent, {
    width: '100%',
    minHeight: 'calc(100vh - 90px)',
    height : 'auto',
     data: {name:"sourahb"}
   });

   dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`); 
   
    
  });
 }



/*  updateUser(row_obj:any) {
  this.dataSources = this.dataSources.filter((value:any,key:any)=>{
    if(value.id == row_obj.id){
      value.name = row_obj.name;
      value.password = row_obj.password;
      value.email = row_obj.email;
      value.mobile = row_obj.mobile;
    }
    return true;
  });
} */
}
