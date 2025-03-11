package com.backendlld.bookmyshowapr24morning.service;

import com.backendlld.bookmyshowapr24morning.model.ShowSeat;
import com.backendlld.bookmyshowapr24morning.model.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    public double calculatePrice(List<ShowSeat> seats, List<ShowSeatType> showSeatTypes) {
        double price = 0;
        for(ShowSeat showSeat: seats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeatType.getSeatType() == showSeat.getSeat().getSeatType()){
                    price += showSeatType.getPrice();
                }
            }
        }
        return price;
    }
}
