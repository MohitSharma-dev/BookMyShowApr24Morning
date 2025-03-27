package com.backendlld.bookmyshowapr24morning.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class BookingRequestDTO {
    long showId;
    List<Long> showSeatIds;
    long userId;
}
