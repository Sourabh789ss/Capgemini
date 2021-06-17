import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Book } from '../book';
import { FlightBookingService } from '../flight-booking.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class BookingComponent implements OnInit {

  value1 = "";  //clear input
  value2 = "";  //clear input
  value3 = "";  //clear input
  value4 = "";  //clear input

  //Add Snack Bar
 openSnackBar() {
  this._snackBar.open('Request Submitted', 'Logging in', {
    duration: 2000,
  });
}


  book : Book = new Book("","","",0,0);
  fmessage: any;

  constructor(private flightService : FlightBookingService,  private _snackBar: MatSnackBar){

  }

  ngOnInit(): void {
  }

  public registerFlight(){
    let resp=this.flightService.doBooking(this.book);
    resp.subscribe((data)=>this.fmessage=data);
      }

}
