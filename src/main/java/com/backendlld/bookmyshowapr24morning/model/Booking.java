package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(callSuper=false) //as good practice.
public class Booking extends BaseModel {
    private Date bookingDate;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats;//pnp:check this..as Mohit said..one seat can be cancelled so it can be many to many.As one ShowSeat can have associations with many Shows.
    @ManyToOne
    private User user;
    @OneToMany
    private List<Payment> payments;
    //@ManyToOne
    @Enumerated(EnumType.STRING)
    BookingStatus bookingStatus;//added booing status for maintaining status of booking.


    //Getters and Setters:

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<ShowSeat> seats) {
        this.seats = seats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}


// Booking M : 1 User
// Booking M:1 Show


// Booking ?? : M ShowSeats

// cancellation

// Show me my bookings

//Booking table
//        1 Mohit Show1 Cancelled
//
//ShowSeat table
//        Show1 Seat1 null Available


// HW :
// Complete all the cardinalities
// How do you represent the cardinalities of enums
// Try to run the application : You will face certain issues
// Try to debug the issues : chatgpt / google
// OneToMany , ManyToOne : Do we create a new table ? No : when app run successfully, separate tables will be created
// How to avoid this ?


// Sign Up
// email password

// Controller : UserController