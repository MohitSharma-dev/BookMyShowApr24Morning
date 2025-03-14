package com.backendlld.bookmyshowapr24morning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookShowRequestDto {
    private Long showId;
    private List<Long> showSeatIds;
    private Long userId;
}
