package com.ahmed.movies_api.Repo;

import com.ahmed.movies_api.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie , Integer> {
    Optional<Movie> findByTitle(String title);
}
