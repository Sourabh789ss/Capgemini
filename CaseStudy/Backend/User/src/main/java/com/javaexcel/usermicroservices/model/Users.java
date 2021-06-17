package com.javaexcel.usermicroservices.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "Users")
@Document(collection = "Usersdb")
public class Users {

    //Auto generated sequence
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";


    @Id
    @GeneratedValue
    @ApiModelProperty(notes = "The unique user id for the user")
    private int id;
    @ApiModelProperty(notes = "The First Name for the user")
    private String username;
    @ApiModelProperty(notes = "The Last Name for the user")
    private String password;

  //  @Indexed(unique = true)
    @ApiModelProperty(notes = "The Email id for the user")
    private String email;
  //  @Indexed(unique = true)
    @ApiModelProperty(notes = "The Mobile number for the user")
    private String mobile ;

   /* private String username;
    private String password;*/

 /*   private int bId;
    private String flightName;*/
    private List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Users(int id, String username, String password, String email, String mobile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }
}
