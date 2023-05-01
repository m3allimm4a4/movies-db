package com.beshara.moviesdbapi.dto.genre;

import jakarta.persistence.Basic;
import org.springframework.lang.NonNull;

public class GenreCreateDto {
    private String name;

    public GenreCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
