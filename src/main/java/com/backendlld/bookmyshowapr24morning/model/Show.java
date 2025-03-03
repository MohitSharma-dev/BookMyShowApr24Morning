package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Date date;
    private Movie movie;
    private Screen screen;
    private Date endTime;
    private List<ShowSeat> showSeats;
    private List<ShowSeatType> showSeatTypes;
}
// Screen features will directly associate with Show features
