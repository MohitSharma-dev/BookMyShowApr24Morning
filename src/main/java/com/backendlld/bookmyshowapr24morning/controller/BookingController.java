package com.backendlld.bookmyshowapr24morning.controller;

import com.backendlld.bookmyshowapr24morning.dto.BookingRequestDTO;
import com.backendlld.bookmyshowapr24morning.dto.BookingResponseDTO;
import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import com.backendlld.bookmyshowapr24morning.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookingResponseDTO bookTicket(BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO response = new BookingResponseDTO();
        try{
            Booking booking = bookingService.bookTicket(bookingRequestDTO.getUserEmail(),
                    bookingRequestDTO.getShowId(),
                    bookingRequestDTO.getBookingDate(),
                    bookingRequestDTO.getSeatIds());
            Float bookingAmount = 0f;
            List<Long> bookedSeatIds = new ArrayList<>();
            for(int i = 0; i < booking.getSeats().size(); i++){
                ShowSeat showSeat = booking.getSeats().get(i);
                bookingAmount += showSeat.getAmount();
                bookedSeatIds.add(showSeat.getId());
            }

            response.setBookingID(booking.getId());
            response.setBookedSeatIds(bookedSeatIds);
            response.setAmount(bookingAmount);
            response.setMessage("Ticket Booked!");
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex){
            response.setMessage("Ticket Booking Failed!");
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }
}
