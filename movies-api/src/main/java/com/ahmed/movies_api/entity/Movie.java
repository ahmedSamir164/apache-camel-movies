package com.ahmed.movies_api.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String releaseDate;
    private  String director;

    public Movie() {
    }

    public Movie(String title, String releaseDate, String director) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
