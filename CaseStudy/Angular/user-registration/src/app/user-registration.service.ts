import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {


  constructor(private http:HttpClient) { }


  public doRegistration(user: any){
    return this.http.post("http://localhost:8282/user/addUser",user,{responseType:'text' as 'json'});
  }

  public getUsers(){
    return this.http.get("http://localhost:8282/user/user/");
  }

  public getUserByEmail(email : String){
    return this.http.get("http://localhost:8282/user/euser/"+email);
  }

  public deleteUser(id:any){
    return this.http.delete("http://localhost:8282/user/deleteUser/"+id);
  } 

  public updateUser(user:any){
    return this.http.put("http://localhost:8282/user/user/", user);
  }
}
