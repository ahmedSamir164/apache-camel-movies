package com.movies.Service;
import com.movies.entity.Movie;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public void saveMovie(Movie movie) {
        producerTemplate.sendBody("direct:addMovie", movie);
    }

    public List<Movie> getAllMovies() {
        return producerTemplate.requestBody("direct:getAllMovies", null, List.class);
    }

}
