import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Book } from '../book';
import { FlightBookingService } from '../flight-booking.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {

  constructor(private flightService: FlightBookingService) { }

  /* booking: any; */
  source!: string;
  date!:Date;

  
  ELEMENT_DATA!: Book[];
  displayedColumns: string[] = [ 'id','flightName', 'source', 'destination','date', 'fair','Action'];
  dataSource = new MatTableDataSource<Book>(this.ELEMENT_DATA);

  //paginator
  @ViewChild(MatPaginator,{static: true}) paginator!: MatPaginator;

  //sorting
  @ViewChild(MatSort, {static: true}) sort!: MatSort;

  //apply filter
  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }



  //functions

  public delteBooking(id:any){
    let resp= this.flightService.deleteBooking(id);
    resp.subscribe((datareq)=>this.dataSource.data = datareq as Book[]);
   }
  

   public findFlightBySources(){
     let resp= this.flightService.getBookingBySource(this.source)
     resp.subscribe((datareq)=>this.dataSource.data = datareq as Book[]);
    }
   
    public findFlightByDate(){
      let resp= this.flightService.getBookingByDate(this.date)
      resp.subscribe((datareq)=>this.dataSource.data= datareq as Book[]);
     }
    

     ngOnInit() {

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort=this.sort;

       let resp=this.flightService.getBooking();
       resp.subscribe((datareq)=>this.dataSource.data = datareq as Book[])
     }

}
