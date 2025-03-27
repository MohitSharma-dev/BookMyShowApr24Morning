package com.backendlld.bookmyshowapr24morning.controller;


import com.backendlld.bookmyshowapr24morning.dto.BookShowRequestDto;
import com.backendlld.bookmyshowapr24morning.dto.BookShowResponseDto;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.model.BookingStatus;
import com.backendlld.bookmyshowapr24morning.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookShowResponseDto bookShow(BookShowRequestDto request){
        BookShowResponseDto response = new BookShowResponseDto();
        try{
            Booking booking = bookingService.bookShow(request.getShowId(),request.getShowSeatIds(),request.getUserId());
            response.setBookingId(booking.getId());
            response.setBookedSeats(booking.getSeats().stream().map(showSeat -> showSeat.getSeat().getId()).toList());
            response.setStatus(BookingStatus.SUCCESSFUL);
            response.setMessage("Booking Successful");
        }
        catch (Exception e){
            response.setStatus(BookingStatus.FAILED);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
