package com.javaexcel.usermicroservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Booking {

    //Auto generated sequence
 /*   @Transient
    public static final String SEQUENCE_NAME = "book_sequence";
*/

    @ApiModelProperty(notes = "The unique booking id for the flight")
    private int bId;
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

}