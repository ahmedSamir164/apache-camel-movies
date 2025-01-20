package com.movies.Controller;

import com.movies.Service.MovieService;
import com.movies.entity.Movie;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody @Valid Movie movie , BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().get(0).getDefaultMessage();
            logger.error("Couldn't add movie : {}", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't add Movie: " + errorMessage);
        }
        movieService.saveMovie(movie);
        return ResponseEntity.ok("Movie saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

}
