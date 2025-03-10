package com.backendlld.bookmyshowapr24morning.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BookingResponseDTO {
    private Long bookingID;
    private Float amount;

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<Long> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Long> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private List<Long> bookedSeatIds;
    private String message;
    private String showDetails;
    private ResponseStatus responseStatus;
}
