package com.driver;

import java.util.*;

public class MovieRepository {
    HashMap<String, ArrayList<String>> pair = new HashMap<>();
    HashMap<String,Movie> movies = new HashMap<>();
    HashMap<String,Director> directors = new HashMap<>();

    public boolean addMovie(Movie movie) {
        movies.put(movie.getName(),movie);
        return true;
    }

    public Optional<Movie> ischeckmovie(String moviename) {
        if(movies.containsKey(moviename)){
            return Optional.of(movies.get(moviename));
        }
        return Optional.empty();
    }

    public Optional<Director> ischeckdirector(String directorname) {
        if(directors.containsKey(directorname)){
            return Optional.of(directors.get(directorname));
        }
        return Optional.empty();
    }

    public boolean addDirector(Director director) {
        directors.put(director.getName(),director);
        return true;
    }

    public boolean addMovieDirectorPair(String moviename, String directorname) {
        if(pair.containsKey(directorname)){
            pair.get(directorname).add(moviename);
        }
        else{
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(moviename);
            pair.put(directorname,tmp);
        }
        return true;
    }

    public List<String> getMoviesByDirectorName(String name) {
        return pair.get(name);
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(movies.keySet());
    }

    public void deletedirector(String director) {
        directors.remove(director);
        pair.remove(director);
    }

    public void deletemovies(String x) {
        movies.remove(x);
    }

    public List<String> getallDirector() {
        return new ArrayList<>(directors.keySet());
    }
}
