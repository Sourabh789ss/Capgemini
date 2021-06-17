import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserRegistrationService } from './user-registration.service';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { BookingComponent } from './booking/booking.component';
import { FlightBookingService } from './flight-booking.service';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle'
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { PaymentComponent } from './payment/payment.component';
import {  NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UpdateSearchComponent } from './update-search/update-search.component';
import { MatDialogModule} from '@angular/material/dialog';
import { UserBookingComponent } from './user-booking/user-booking.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatList, MatListModule} from '@angular/material/list';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    SearchComponent,
    HomeComponent,
    BookingComponent,
    SearchFlightComponent,
    PaymentComponent,
    UpdateSearchComponent,
    UserBookingComponent,
    NavBarComponent,
    DashboardComponent
    
  ],
  entryComponents : [
    UpdateSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatSlideToggleModule,
    MatCardModule,
    MatIconModule,
    ReactiveFormsModule  ,
    MatSnackBarModule,
    MatMenuModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgbModule,
    MatDialogModule,
    MatSidenavModule,
    MatListModule,
    MatButtonToggleModule,

    
  ],
  exports: [
    MatDatepickerModule,
    MatNativeDateModule,
    
  ],

  providers: [UserRegistrationService, FlightBookingService],
  bootstrap: [AppComponent]
})
export class AppModule { }


