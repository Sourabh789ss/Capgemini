package com.javaexcel.booking.repository;

import com.javaexcel.booking.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends MongoRepository<Booking , Integer> {
    public List<Booking> findBySource(String source);

    //search by Date
    public List<Booking> findByDate(Date date);

    public List<Booking> findByuId(Integer uId);

    //Testing
    List<Booking> findByDepartureDate(Date departureDate);

    @Query("select a from booking a where a.arrivalDateTime <= :arrivalDateTime")
    List<Booking> findAllByArrivalTime(@Param("arrivalTime") Date arrivalTime);
}
