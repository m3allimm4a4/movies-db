package com.beshara.moviesdbapi.exceptions.genre;

public class GenreEmptyNameException extends RuntimeException{
    public GenreEmptyNameException() {
        super("Genre name is empty");
    }
}
