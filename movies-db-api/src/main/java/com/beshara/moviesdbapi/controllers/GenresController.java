package com.beshara.moviesdbapi.controllers;

import com.beshara.moviesdbapi.dto.genre.GenreCreateDto;
import com.beshara.moviesdbapi.exceptions.genre.GenreNotFoundException;
import com.beshara.moviesdbapi.models.Genre;
import com.beshara.moviesdbapi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/genre")
@RestController
public class GenresController {
    private final GenreService genreService;

    @Autowired
    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") long id) {
        try {
            return genreService.getGenre(id);
        } catch (GenreNotFoundException e) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Genre createGenre(@RequestBody GenreCreateDto genreCreateDto) {
        return genreService.addGenre(genreCreateDto.getName());
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable("id") long id, @RequestBody GenreCreateDto newGenre) {
        try {
            return genreService.updateGenre(id, newGenre.getName());
        } catch (GenreNotFoundException e) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable("id") long id) {
        try {
            genreService.deleteGenre(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (GenreNotFoundException e) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }
}
