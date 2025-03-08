package com.backendlld.bookmyshowapr24morning.dto;


import com.backendlld.bookmyshowapr24morning.model.BookingStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponseDTO {
    long bookingId;
    double amount;//This is for a total of all payments whose status s completed.
    List<Long> bookedShowSeats;//Note:Partial booking is not allowed, so its all or none seat, kind of scenario.
    long showId;
    String movieTitle;
    BookingStatus bookingStatus;
    ResponseStatus responseStatus;
}
//pnp.Q..to Mohit...why we return here just Ids and not the object reference.
