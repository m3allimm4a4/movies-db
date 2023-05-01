package com.beshara.moviesdbapi.exceptions.movie;

public class MovieSearchEmptyQueryException extends RuntimeException{
    public MovieSearchEmptyQueryException(){
        super("Must provide a valid non empty query ");
    }
}
