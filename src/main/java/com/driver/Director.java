package com.driver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}
