package com.hotel.reservation.service.model;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    private long guestId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String state;
    private String country;
    private String phoneNo;

}
