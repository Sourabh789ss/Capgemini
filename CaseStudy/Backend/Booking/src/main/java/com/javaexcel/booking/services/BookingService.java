//package com.javaexcel.booking.services;

import com.javaexcel.booking.common.UserRequest;
import com.javaexcel.booking.models.Booking;
import com.javaexcel.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

//@Service
//public class BookingService {
//    @Autowired
//    private BookingRepository bookingRepository;
//    @Autowired
//    private RestTemplate restTemplate;
//    public String setFlights(@RequestBody UserRequest request){
//        //String msgResponse = "";
       // Booking booking =  request.getBooking();
      //  Users users = request.getUsers();
       // users.setBookingId(booking.getBookingId());
       // users.setFlightName(booking.getFlightName());

        //restCall

      //  Users userResponse = restTemplate.getForObject("http://USER-SERVICE/user/AddUser",Users.class);
         //msgResponse = "finally done with microservice";
      //  bookingRepository.save(booking);
      // return "booking";
    //  return (List<UserResponse>) new UserResponse(booking, userResponse.getId(), userResponse.getFirstName());
//    }

//}
