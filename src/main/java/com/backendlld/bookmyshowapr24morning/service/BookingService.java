package com.backendlld.bookmyshowapr24morning.service;


import com.backendlld.bookmyshowapr24morning.excptions.SeatsNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.ShowNotAvailableException;
import com.backendlld.bookmyshowapr24morning.excptions.ShowSeatNotFoundException;
import com.backendlld.bookmyshowapr24morning.excptions.UserNotFoundException;
import com.backendlld.bookmyshowapr24morning.model.Booking;

import java.util.List;

public interface BookingService {
    Booking bookShow( long showId, List<Long> showSeatIds, long userId) throws SeatsNotAvailableException, ShowNotAvailableException, UserNotFoundException, ShowSeatNotFoundException;
}
