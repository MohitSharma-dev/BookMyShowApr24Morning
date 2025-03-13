package com.backendlld.bookmyshowapr24morning.dto;

import com.backendlld.bookmyshowapr24morning.model.BookingStatus;

import java.util.List;

public class BookShowResponseDto {
    private Long bookingId;
    private Double amount;
    private List<Long> bookedShowSeatIds;
    private BookingStatus bookingStatus;
}
