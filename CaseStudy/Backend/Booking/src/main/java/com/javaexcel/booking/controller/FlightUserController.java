package com.javaexcel.booking.controller;

import com.javaexcel.booking.models.Booking;
import com.javaexcel.booking.repository.BookingRepository;

import com.javaexcel.booking.services.SequenceGeneratorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.javaexcel.booking.models.Booking.SEQUENCE_NAME;


@RestController
@RequestMapping("/booking")
/*@CrossOrigin(origins = "*")*/
public class FlightUserController {


    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/addUserBooking")
    @ApiOperation(value = "Add FLight Booking details",
            notes ="Add the details of specific Flight",
            response = Booking.class)
    public String addBooking(@RequestBody Booking booking) {

        //generate sequence
        booking.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        bookingRepository.save(booking);
        return "Booked user-Flight with id : "+ booking.getId() ;
    }

    @GetMapping("/user")
    @ApiOperation(value = "Find all the FLight Booking details",
            notes ="Retrieve all the details of specific Flight",
            response = Booking.class)
    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }


    @GetMapping("/getuser/{uId}")
    @ApiOperation(value = "Finds Booking by Id",
            notes ="Provide an id to look up specific Flight",
            response = Booking.class)

    public List<Booking> getBookingById(@ApiParam(value = "ID value for the Booking you need to retrieve", required = true)
                                            @PathVariable("uId") Integer uId){
        return bookingRepository.findByuId(uId);
    }



    //get by date
    @GetMapping("/user/{date}")
    @ApiOperation(value = "Find the User details having specific date",
            notes ="Provide an date to look up details of specific flight",
            response = Booking.class)
    public List<Booking> findByFlight(@ApiParam(value = "Date related value for the Flight you need to retrieve", required = true)
                                      @PathVariable Date date) {
        return bookingRepository.findByDate(date);
    }




    @PutMapping("/user/{uId}")
    @ApiOperation(value = "Update Booking by Id",
            notes ="Provide an id to look up specific Flight",
            response = Booking.class)
    public Booking updateBooking(@ApiParam(value = "ID value for the Booking you need to update", required = true)
                                 @RequestBody Booking booking, @PathVariable Integer uId){
        return bookingRepository.findById(uId)
                .map(book ->{
                    book.setId(booking.getId());
                    book.setFlightName(booking.getFlightName());
                    book.setDestination(booking.getDestination());
                    book.setSource(booking.getSource());
                    book.setDate(booking.getDate());
                    book.setFair(booking.getFair());
                    book.setUId(booking.getUId());

                    return bookingRepository.save(booking);
                })
                .orElseGet(() ->{
                    booking.setId(uId);
                    return bookingRepository.save(booking);
                });
    }



    @DeleteMapping("/deleteUser/{uId}")
    @ApiOperation(value = " Delete Booking by Id",
            notes ="Provide an id to look up specific Flight",
            response = Booking.class)
    public String deleteBooking(@ApiParam(value = "ID value for the Booking you need to delete", required = true)
                                @PathVariable Integer uId){
        bookingRepository.deleteById(uId);
        return "Flight deleted with id: " + uId ;
    }



}
