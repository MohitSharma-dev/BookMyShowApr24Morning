package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String title;
    private String year;
    private String director;
    private String genre;
    private String rating;
    private String description;
    private List<Feature> movieFeatures;
}
