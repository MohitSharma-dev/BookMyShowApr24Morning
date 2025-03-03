package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private List<Booking> bookings;
}

// mysql : enum data types

// mapping tables ?
