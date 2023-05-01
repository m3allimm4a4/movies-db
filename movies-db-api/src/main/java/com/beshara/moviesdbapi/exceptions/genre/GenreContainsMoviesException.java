package com.beshara.moviesdbapi.exceptions.genre;

public class GenreContainsMoviesException extends RuntimeException{
    public GenreContainsMoviesException() {
        super("Genre contains movies");
    }
}
