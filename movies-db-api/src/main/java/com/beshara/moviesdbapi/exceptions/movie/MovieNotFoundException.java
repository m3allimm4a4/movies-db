package com.beshara.moviesdbapi.exceptions.movie;

import com.beshara.moviesdbapi.exceptions.NotFoundException;

public class MovieNotFoundException extends NotFoundException {
    public MovieNotFoundException() {
        super("Movie not found");
    }
}
