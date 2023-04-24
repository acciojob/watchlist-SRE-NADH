package com.driver;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieService {
    MovieRepository repo = new MovieRepository();
    public boolean addMovie(Movie movie) throws movieAlredyPresentException {
        Optional<Movie> opt = repo.ischeckmovie(movie.getName());
        if(opt.isPresent()){
            throw new movieAlredyPresentException();
        }
        return repo.addMovie(movie);
    }

    public boolean addDirector(Director director) throws directorAlreadyPresent {
        Optional<Director> opt = repo.ischeckdirector(director.getName());
        if(opt.isPresent()){
            throw new directorAlreadyPresent();
        }
        return repo.addDirector(director);
    }

    public boolean addMovieDirectorPair(String moviename, String directorname) throws MovieOrDirectornotpresentException {
        Optional<Movie> optm = repo.ischeckmovie(moviename);
        Optional<Director> optd = repo.ischeckdirector(directorname);
        if(optm.isEmpty() || optd.isEmpty()){
            throw new MovieOrDirectornotpresentException();
        }
       return repo.addMovieDirectorPair(moviename,directorname);
    }

    public Movie getMovieByName(String moviename) {
        Optional<Movie> m = repo.ischeckmovie(moviename);
        if(m.isPresent()){
            return m.get();
        }
        return new Movie();
    }
    public Director getDirectorByName(String name) {
        Optional<Director> m = repo.ischeckdirector(name);
        if(m.isPresent()){
            return m.get();
        }
        return new Director();
    }

    public List<String> getMoviesByDirectorName(String name) {
        List<String> movies = repo.getMoviesByDirectorName(name);
        return movies;
    }

    public List<String> findAllMovies() {
        List<String> m = repo.findAllMovies();
        return m;
    }

    public void deleteDirectorByName(String director) {
        List<String> movies = repo.getMoviesByDirectorName(director);
        repo.deletedirector(director);
        for(String x:movies){
           repo.deletemovies(x);
        }
    }
    public void deleteAllDirector() {
        List<String> dir = repo.getallDirector();
        for(String x:dir){
            List<String> mo = repo.getMoviesByDirectorName(x);
            for(String y :mo){
                repo.deletemovies(y);
            }
        }
    }


}
