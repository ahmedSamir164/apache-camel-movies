package com.ahmed.movies_api.Controller;

import com.ahmed.movies_api.Service.MovieService;
import com.ahmed.movies_api.entity.Movie;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>>getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies() , HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId (@PathVariable String title){
        return new ResponseEntity<>(movieService.getMovieByTitle(title) , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
            String result = movieService.addMovie(movie);
            if (result.startsWith("Error:")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
            }
            return ResponseEntity.ok(result);
    }
}
