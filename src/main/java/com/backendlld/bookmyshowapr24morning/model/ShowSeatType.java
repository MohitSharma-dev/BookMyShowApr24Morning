package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private double price;

    //Getters and Setters:

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}


// show_id , seattype_id , price
// 1 , GOLD
// 1 , Silver,
// 1 , Platinum

// 2 , Gold
// 2 , Silver