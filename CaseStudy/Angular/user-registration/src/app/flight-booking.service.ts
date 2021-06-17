import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightBookingService {

  constructor(private http:HttpClient) { }


  public doBooking(book:any){
    return this.http.post("http://localhost:8585/book/addBooking",book,{responseType:'text' as 'json'});
  }

  public getBooking(){
    return this.http.get("http://localhost:8585/book/booking/");
  }

  public getBookingBySource(source : String){
    return this.http.get("http://localhost:8585/book/sbooking/"+source);
  }

  public getBookingByDate(date : Date){
    return this.http.get("http://localhost:8585/book/dbooking/"+date);
  }

  public deleteBooking(id: any){
    return this.http.delete("http://localhost:8585/book/deleteBooking/"+id);
  } 

}


