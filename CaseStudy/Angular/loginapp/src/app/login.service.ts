import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


 /*  url="http://localhost:8282" */
  url="http://localhost:8787" 

  constructor(private http: HttpClient) { }
// calling server to generate token

generateToken(credentials: any){
    return this.http.post(`${this.url}/token`, credentials)
}


  loginUser(token : any)
  {
    localStorage.setItem("token",token)
    return true;
  }
  //to check user is logged in or not
  isLoggedIn(){
   let token = localStorage.getItem("token");
   if(token==undefined || token==''|| token==null){
     return false;
   }
   else{
     return true;
   }
  }

  logout(){
    localStorage.removeItem('token');
    return true;
  }

  //for get token
 getToken(){
   return localStorage.getItem("token")
 }

 
}



