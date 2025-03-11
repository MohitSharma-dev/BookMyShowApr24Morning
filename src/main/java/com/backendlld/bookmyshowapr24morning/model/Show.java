package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    private Date date;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date endTime;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<ShowSeatType> showSeatTypes;

    //Getters and Setters:


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public List<ShowSeatType> getShowSeatTypes() {
        return showSeatTypes;
    }

    public void setShowSeatTypes(List<ShowSeatType> showSeatTypes) {
        this.showSeatTypes = showSeatTypes;
    }
}
// Screen features will directly associate with Show features

// Show M : 1 Movie
// Show M : 1 Screen