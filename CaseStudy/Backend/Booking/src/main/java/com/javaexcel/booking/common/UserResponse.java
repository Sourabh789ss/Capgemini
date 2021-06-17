package com.javaexcel.booking.common;

import com.javaexcel.booking.models.Booking;
import lombok.*;

import java.math.BigInteger;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Booking booking;
    //private BigInteger userId;
    private String firstName;
   // private String message;
}
