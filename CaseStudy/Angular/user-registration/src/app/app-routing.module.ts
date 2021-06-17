import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookingComponent } from './booking/booking.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { PaymentComponent } from './payment/payment.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SearchComponent } from './search/search.component';
import { UpdateSearchComponent } from './update-search/update-search.component';
import { UserBookingComponent } from './user-booking/user-booking.component';
const routes: Routes = [
  {path:"",redirectTo:"home", pathMatch:"full"},
  {path:"home", component:HomeComponent},
  {path:"register", component:RegistrationComponent},
  {path:"search", component:SearchComponent},
  {path:"booking", component:BookingComponent},
  {path:"searchFlight", component:SearchFlightComponent},
  {path:"updateSearch", component:UpdateSearchComponent},
  {path:"userBooking", component:UserBookingComponent},
  {path:"payment", component:PaymentComponent, pathMatch:"full"},
  {path:"dashboard", component:DashboardComponent, pathMatch:"full"},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
