package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private ShowSeatStatus status;
}
