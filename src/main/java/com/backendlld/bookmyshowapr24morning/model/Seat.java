package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    private int row;
    private int column;
    private SeatType seatType;
}

