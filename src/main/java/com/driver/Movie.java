package com.driver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Movie {
    private String name;
    private int durationInMinutes;
    private double imdbRating;
    public Movie(String name, int durationInMinutes,double imdbRating){
        this.name =name;
        this.durationInMinutes=durationInMinutes;
        this.imdbRating = imdbRating;
    }
}
