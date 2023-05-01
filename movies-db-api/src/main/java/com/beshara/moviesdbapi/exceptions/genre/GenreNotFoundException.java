package com.beshara.moviesdbapi.exceptions.genre;

public class GenreNotFoundException extends RuntimeException{
    public GenreNotFoundException() {
        super("Genre Not Found");
    }
}
