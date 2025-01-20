package com.ahmed.movies_api.Service;

import com.ahmed.movies_api.Repo.MovieRepository;
import com.ahmed.movies_api.entity.Movie;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;
    @Autowired
    private ProducerTemplate producerTemplate;

    public String addMovie(Movie movie) {
       return  producerTemplate.requestBody("direct:processMovies", movie, String.class);
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> getMovieByTitle(String title) {
        return repository.findByTitle(title);
    }
}
