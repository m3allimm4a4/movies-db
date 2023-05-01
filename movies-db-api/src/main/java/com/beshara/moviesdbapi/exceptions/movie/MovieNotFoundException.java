package com.beshara.moviesdbapi.exceptions.movie;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException() {
        super("Movie not found");
    }
}
