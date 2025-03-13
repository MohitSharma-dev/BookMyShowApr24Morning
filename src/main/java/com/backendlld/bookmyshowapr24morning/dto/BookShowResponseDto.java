package com.backendlld.bookmyshowapr24morning.dto;

import com.backendlld.bookmyshowapr24morning.model.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookShowResponseDto {
    private Long bookingId;
    private Double amount;
    private List<Long> bookedShowSeatIds;
    private BookingStatus bookingStatus;
    private ResponseStatus responseStatus;
}
