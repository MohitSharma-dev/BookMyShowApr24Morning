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

    //getters and setters:


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Feature> getMovieFeatures() {
        return movieFeatures;
    }

    public void setMovieFeatures(List<Feature> movieFeatures) {
        this.movieFeatures = movieFeatures;
    }
}

// Ordinal vs String

// Movie
// Feature : 0,1,3

//
