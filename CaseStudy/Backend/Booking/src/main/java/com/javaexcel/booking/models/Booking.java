package com.javaexcel.booking.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Document(collection = "flightbook")
@ApiModel(description = "Details about the Booking service")
public class Booking {

    //Auto generated sequence
    @Transient
    public static final String SEQUENCE_NAME = "book_sequence";


    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The unique booking id for the flight")
    private int id;
    @ApiModelProperty(notes = "The name of the flight")
    private String flightName;
    @ApiModelProperty(notes = "The source of the flight form where your journey started")
    private String source;
    @ApiModelProperty(notes = "The destination of the flight form where your journey will end")
    private String destination;
    @ApiModelProperty(notes = "The Date of the flight when it will Booked.")
    private Date date;
    //private Timestamp time;
    @ApiModelProperty(notes = "The cost of the flight ticket")
    private int fair;

    //it is from user-service
    @ApiModelProperty(notes = "The user Id which has booked the ticket which will get value from user-microservice")
    private int uId;

    public Booking(int id, String flightName, String source, String destination, int fair, int uId) {
        this.id = id;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.fair = fair;
        this.uId = uId;
    }

    public Booking(int id, String flightName, String source, String destination, Date date, int fair, int uId) {
        this.id = id;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.fair = fair;
        this.uId = uId;
    }

    /*    private String firstName;*/


    @Temporal(TemporalType.DATE)
    Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    Date arrivalTime;

    public Booking(Date departureDate, Date arrivalTime) {
        this.departureDate = departureDate;
        this.arrivalTime = arrivalTime;
    }

    public Booking(Date departureDate) {
        this.departureDate = departureDate;
    }
}