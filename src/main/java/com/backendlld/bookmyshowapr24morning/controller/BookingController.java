package com.backendlld.bookmyshowapr24morning.controller;

import com.backendlld.bookmyshowapr24morning.dto.BookingRequestDTO;
import com.backendlld.bookmyshowapr24morning.dto.BookingResponseDTO;
import com.backendlld.bookmyshowapr24morning.dto.ResponseStatus;
import com.backendlld.bookmyshowapr24morning.excptions.SeatsNotAvailableExcpetion;
import com.backendlld.bookmyshowapr24morning.excptions.ShowNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.Booking;
import com.backendlld.bookmyshowapr24morning.model.Payment;
import com.backendlld.bookmyshowapr24morning.model.PaymentStatus;
import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import com.backendlld.bookmyshowapr24morning.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class BookingController {

    BookingServiceImpl bookingService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService){
        this.bookingService = bookingService;
    }

    public BookingResponseDTO bookShow(BookingRequestDTO requestDto){
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try{
            Booking booking = bookingService.bookShow(requestDto.getShowId(), requestDto.getShowSeatIds(), requestDto.getUserId());
            ///bookingResponseDTO.setBookingId(booking::getId);//pnp...getting error:"long is not a functional interface"
            bookingResponseDTO.setBookingId(booking.getId());

            bookingResponseDTO.setAmount(booking.getPayments().stream().filter(pymt-> pymt.getPaymentStatus()== PaymentStatus.SUCCESSFUL).mapToDouble(Payment::getTotalAmount).sum());
            bookingResponseDTO.setBookedShowSeats(booking.getSeats().stream().map(ShowSeat::getId).collect(Collectors.toList()));
            bookingResponseDTO.setShowId(booking.getShow().getId());
            bookingResponseDTO.setMovieTitle(booking.getShow().getMovie().getTitle());//pnp..this is because i want to send specific data for front end, so they can share it user and print it in the ticket.
            bookingResponseDTO.setBookingStatus(booking.getBookingStatus());
            bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(SeatsNotAvailableExcpetion e){
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        } catch (ShowNotAvailableException e) {
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        } catch (UserNotFoundException e) {
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookingResponseDTO;
    }
}
