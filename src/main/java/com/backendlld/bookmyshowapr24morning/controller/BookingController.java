package com.backendlld.bookmyshowapr24morning.controller;

import com.backendlld.bookmyshowapr24morning.dto.BookingRequestDto;
import com.backendlld.bookmyshowapr24morning.dto.BookingResponseDto;
import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.service.BookingService;
import com.backendlld.bookmyshowapr24morning.service.PriceCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private PriceCalculationService priceCalculationService;

    public BookingResponseDto bookShow(BookingRequestDto requestDto){
        BookingResponseDto responseDto = new BookingResponseDto();
        try{
            Booking booking = bookingService.bookShow(requestDto.getShowSeatIds(), requestDto.getShowId(), requestDto.getUserId());
            responseDto.setBookingId(booking.getId());
            responseDto.setBookedSeats(booking.getSeats());
            responseDto.setShowDetails(booking.getShow());
            responseDto.setAmount(priceCalculationService.calculatePrice(booking.getSeats(),booking.getShow().getShowSeatTypes()));
            responseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
