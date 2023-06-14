package com.beshara.moviesdbapi.exceptions.genre;

import com.beshara.moviesdbapi.exceptions.NotFoundException;

public class GenreNotFoundException extends NotFoundException {
    public GenreNotFoundException() {
        super("Genre Not Found");
    }
}
