package com.backendlld.bookmyshowapr24morning.dto;


import com.backendlld.bookmyshowapr24morning.model.BookingStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookingResponseDTO {
    long bookingId;
    double amount;//This is for a total of all payments whose status s completed.
    List<Long> bookedShowSeats;//Note:Partial booking is not allowed, so its all or none seat, kind of scenario.
    long showId;
    String movieTitle;
    BookingStatus bookingStatus;
    ResponseStatus responseStatus;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Long> getBookedShowSeats() {
        return bookedShowSeats;
    }

    public void setBookedShowSeats(List<Long> bookedShowSeats) {
        this.bookedShowSeats = bookedShowSeats;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
//pnp.Q..to Mohit...why we return here just Ids and not the object reference.
