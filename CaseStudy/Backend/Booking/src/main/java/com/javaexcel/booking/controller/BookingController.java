package com.javaexcel.booking.controller;

import com.javaexcel.booking.models.Booking;
import com.javaexcel.booking.repository.BookingRepository;
import com.javaexcel.booking.services.SequenceGeneratorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.javaexcel.booking.models.Booking.SEQUENCE_NAME;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")

public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;


    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @HystrixCommand
    @PostMapping("/addBooking")
    @ApiOperation(value = "Add FLight Booking details",
            notes ="Add the details of specific Flight",
            response = Booking.class)
    public String addBooking(@RequestBody Booking booking) {

        //generate sequence
        booking.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));

         bookingRepository.save(booking);

       return "Booked Flight with id : "+ booking.getId() ;
    }

    @HystrixCommand
    @GetMapping("/booking")
    @ApiOperation(value = "Find all the FLight Booking details",
            notes ="Retrieve all the details of specific Flight",
            response = Booking.class)
    public List<Booking> getAllBooking(){

        return bookingRepository.findAll();
    }

    @HystrixCommand
    @GetMapping("/booking/{id}")
    @ApiOperation(value = "Finds Booking by Id",
                  notes ="Provide an id to look up specific Flight",
                  response = Booking.class)

    public Optional<Booking> getBookingById(@ApiParam(value = "ID value for the Booking you need to retrieve", required = true)
                                            @PathVariable Integer id){
        return bookingRepository.findById(id);
    }


    //get by source
    @HystrixCommand
    @GetMapping("/sbooking/{source}")
    @ApiOperation(value = "Find the User details having specific source",
            notes ="Provide an source to look up details of specific flight",
            response = Booking.class)
    public List<Booking> findBySource(@ApiParam(value = "source related value for the Flight you need to retrieve", required = true)
                                       @PathVariable String source) {
        return bookingRepository.findBySource(source);
    }

    //get by date
    @HystrixCommand
    @GetMapping("/dbooking/{date}")
    @ApiOperation(value = "Find the User details having specific date",
            notes ="Provide an date to look up details of specific flight",
            response = Booking.class)
    public List<Booking> findByFlight(@ApiParam(value = "Date related value for the Flight you need to retrieve", required = true)
                                      @PathVariable Date date) {
        return bookingRepository.findByDate(date);
    }



    @HystrixCommand
    @PutMapping("/booking/{id}")
    @ApiOperation(value = "Update Booking by Id",
            notes ="Provide an id to look up specific Flight",
            response = Booking.class)
    public Booking updateBooking(@ApiParam(value = "ID value for the Booking you need to update", required = true)
                                     @RequestBody Booking booking, @PathVariable Integer id){
        return bookingRepository.findById(id)
                .map(book ->{
                    book.setId(booking.getId());
                    book.setFlightName(booking.getFlightName());
                    book.setDestination(booking.getDestination());
                    book.setSource(booking.getSource());
                    book.setDate(booking.getDate());
                    book.setFair(booking.getFair());
                    book.setUId(booking.getUId());
                  //  book.setTime(booking.getTime());
                    /*book.setUserId(booking.getUserId());*/

                    return bookingRepository.save(booking);
                })
                .orElseGet(() ->{
                    booking.setId(id);
                    return bookingRepository.save(booking);
                });
    }


    @HystrixCommand
    @DeleteMapping("/deleteBooking/{id}")
    @ApiOperation(value = " Delete Booking by Id",
            notes ="Provide an id to look up specific Flight",
            response = Booking.class)
    public String deleteBooking(@ApiParam(value = "ID value for the Booking you need to delete", required = true)
                                    @PathVariable Integer id){
        bookingRepository.deleteById(id);
        return "Flight deleted with id: " + id ;
    }

// microservice
/*
  @PostMapping("/book")
  public List<UserResponse> setFlight(@RequestBody UserRequest request){

        return bookingService.setFlights(request);
  }
*/


}
