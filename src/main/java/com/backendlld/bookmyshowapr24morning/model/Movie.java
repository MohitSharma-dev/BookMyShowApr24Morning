package com.backendlld.bookmyshowapr24morning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedAttribute;

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
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> movieFeatures;
}

// Ordinal vs String

// Movie
// Feature : 0,1,3

//
