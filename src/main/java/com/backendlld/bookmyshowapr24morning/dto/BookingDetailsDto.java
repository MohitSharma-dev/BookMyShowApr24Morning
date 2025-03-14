package com.backendlld.bookmyshowapr24morning.dto;

import com.backendlld.bookmyshowapr24morning.model.Booking;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingDetailsDto {
    private Booking booking;
    private List<Long> showSeatsIds;
    private double amount;
}
