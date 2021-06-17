package com.example.apigateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FallBackController {
    /*
    * FallBack for UserRegistartionService
    */
    @HystrixCommand
    @RequestMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "It seems USER-SERVICE is under maintenance, please try after some time...!";
    }

    /*
     * FallBack for Booking Service
     */
    @HystrixCommand
    @RequestMapping("/bookingServiceFallBack")
    public String bookingServiceFallBackMethod(){
        return "It seems Booking-SERVICE is under maintenance, please try after some time...!";
    }
    /*
     * FallBack for Payment Service
     */
    @HystrixCommand
    @RequestMapping("/paymentServiceFallBack")
    public String paymentServiceFallBackMethod(){
        return "It seems PAYMENT-SERVICE is under maintenance, please try after some time...!";
    }

}
