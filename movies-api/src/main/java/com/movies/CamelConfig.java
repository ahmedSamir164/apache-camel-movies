package com.movies;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CamelConfig extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:addMovie")
                .to("jpa:com.movies.entity.Movie");

        from("direct:getAllMovies")
                .to("jpa:com.movies.entity.Movie?query=select m from Movie m");

    }
}
