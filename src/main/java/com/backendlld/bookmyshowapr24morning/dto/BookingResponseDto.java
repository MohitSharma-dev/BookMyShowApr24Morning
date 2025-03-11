package com.backendlld.bookmyshowapr24morning.dto;

import com.backendlld.bookmyshowapr24morning.model.Show;
import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingResponseDto {
    private Long bookingId;
    private double amount;
    private List<ShowSeat> bookedSeats;
    private Show showDetails;
    private ResponseStatus status;
}
