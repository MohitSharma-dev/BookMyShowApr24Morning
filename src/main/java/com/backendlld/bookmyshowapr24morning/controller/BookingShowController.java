package com.backendlld.bookmyshowapr24morning.controller;

import com.backendlld.bookmyshowapr24morning.dto.BookShowRequestDto;
import com.backendlld.bookmyshowapr24morning.dto.BookShowResponseDto;
import com.backendlld.bookmyshowapr24morning.dto.BookingDetailsDto;
import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingShowController {
    private BookingService bookingService;
    @Autowired
    public BookingShowController(BookingService bookingService){
        this.bookingService=bookingService;
    }
    public BookShowResponseDto bookMyShow(BookShowRequestDto requestDto){
        BookShowResponseDto responseDto=new BookShowResponseDto();
        try{
            BookingDetailsDto bookingDetails= bookingService.bookMyShow(requestDto.getUserId(),requestDto.getShowId(),
                    requestDto.getShowSeatIds());
            responseDto.setBookingId(bookingDetails.getBooking().getId());
            responseDto.setBookingStatus(bookingDetails.getBooking().getBookingStatus());
            responseDto.setAmount(bookingDetails.getAmount());
            responseDto.setBookedShowSeatIds(bookingDetails.getShowSeatsIds());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
