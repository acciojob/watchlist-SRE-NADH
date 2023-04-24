package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    MovieService service = new MovieService();

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        try {
            boolean add = service.addMovie(movie);
            return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
        } catch (movieAlredyPresentException e) {
            return new ResponseEntity("Failed to add movie", HttpStatus.valueOf(400));
        }
    }

    @PostMapping("/movies/add-Director")
    public ResponseEntity addDirector(@RequestBody Director director) {
        try {
            boolean add = service.addDirector(director);
            return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
        } catch (directorAlreadyPresent e) {
            return new ResponseEntity("Failed to add director", HttpStatus.valueOf(400));
        }
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String moviename, @RequestParam String directorname) {
        try {
            boolean add = service.addMovieDirectorPair(moviename,directorname);
            return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
        } catch (MovieOrDirectornotpresentException e) {
            return new ResponseEntity("Failed to add director", HttpStatus.valueOf(400));
        }
    }
 @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name ){
        Movie movie = service.getMovieByName(name);
        return  new ResponseEntity<>(movie,HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name ){
        Director director = service.getDirectorByName(name);
        return  new ResponseEntity<>(director,HttpStatus.OK);
    }
  @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = service.getMoviesByDirectorName(director);
        return new ResponseEntity(movies,HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> movies = service.findAllMovies();
        return new ResponseEntity(movies,HttpStatus.OK);
    }
@DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director){
        service.deleteDirectorByName(director);
        return new ResponseEntity(" success ",HttpStatus.OK);
}
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        service.deleteAllDirector(   );
        return new ResponseEntity(" success ",HttpStatus.OK);
    }

}
