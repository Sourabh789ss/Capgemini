package com.javaexcel.booking.common;

import com.javaexcel.booking.models.Booking;
import lombok.*;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Booking booking;
    //private Users users;

}
