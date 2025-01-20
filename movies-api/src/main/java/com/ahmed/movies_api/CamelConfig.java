package com.ahmed.movies_api;

import com.ahmed.movies_api.Repo.MovieRepository;
import com.ahmed.movies_api.entity.Movie;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelConfig extends RouteBuilder {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void configure() throws Exception {
        from("direct:processMovies")
                .process(exchange -> {
                    Movie movie = exchange.getIn().getBody(Movie.class);

                    if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
                        exchange.getIn().setBody("Error: Movie Title is missing.");
                        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
                        return;
                    }

                    movieRepository.save(movie);
                    exchange.getIn().setBody("Movie saved successfully.");
                })
                .log("${body}");
    }
}
