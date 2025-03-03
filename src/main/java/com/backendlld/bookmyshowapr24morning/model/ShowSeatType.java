package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    private Show show;
    private SeatType seatType;
    private double price;
}
