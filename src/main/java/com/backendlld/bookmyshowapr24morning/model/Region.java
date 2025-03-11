package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;

    //Getters and Setters:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
