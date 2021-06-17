/*
package com.javaexcel.booking;

import com.javaexcel.booking.controller.BookingController;
import com.javaexcel.booking.models.Booking;
import com.javaexcel.booking.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class BookingApplicationTests {
    @Autowired
   private BookingController bookingController;

    @MockBean
    private BookingRepository bookingRepository;

    @Test
    void contextLoads() {
        bookingRepository = mock(BookingRepository.class);
    }

    @Test
   public void getBookingBySourceTest(){

        String source="kangra";
      when(bookingRepository.findBySource(source)).thenReturn(Stream.of(new Booking(11, "Airways","kangra", "pune",2500 ,25)).collect(Collectors.toList()));

      assertEquals(1, bookingRepository.findBySource(source).size());

   }

   @Test
   public void getUsersTest(){
        when(bookingRepository.findAll()).thenReturn(Stream.of(
               new Booking( 11, "Airways","kangra", "pune",2500,44),
                new Booking(12,"IndianAirways","Kolkata","Chennai",2500,22)).collect(Collectors.toList()));

        assertEquals(2,bookingController.getAllBooking().size());
   }

   @Test
    public void whenFindByDepatureDate_thenBooking1And2Returned() throws ParseException {
        List<Booking> result = bookingRepository.findByDepartureDate(
                new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-24"));

        assertEquals(1, result.size());
        assertTrue(result.stream()
                .map(Booking::getId)
                .allMatch(id -> Arrays.asList(1, 2).contains(id)));

    }

    @Test
    public void saveFlightTest(){
        Booking booking = new Booking(78, "londonways","kullu","Mandi",1022,27);

        when(bookingRepository.save(booking)).thenReturn(booking);
        assertEquals(booking, bookingController.addBooking(booking));
    }

    @Test
    public void RemoveFlightTest(){
        Booking booking = new Booking(11, "Airways","kangra", "pune",2500,44);
         bookingController.deleteBooking(booking.getId());
       verify(bookingRepository, times(1)).delete(booking);
    }

    @Test
    public void givenBookingWhenFindWithArriavlDate() throws ParseException {
        List<Booking> result = bookingRepository.findAllByArrivalTime(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2021-4-25 18:30"));

        assertEquals(2, result.size());
        assertTrue(result.stream()
                .map(Booking::getId)
                .allMatch(id -> Arrays.asList(2, 3).contains(id)));
    }
}
*/
