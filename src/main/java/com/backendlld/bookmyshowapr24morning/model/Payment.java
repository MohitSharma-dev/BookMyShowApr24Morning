package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private Date paymentDate;
    private double totalAmount;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private String refNumber;
    private Booking booking;
}
