package com.beshara.moviesdbapi.controllers;

import com.beshara.moviesdbapi.models.dto.genre.GenreCreateDto;
import com.beshara.moviesdbapi.models.dbo.Genre;
import com.beshara.moviesdbapi.services.GenreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/genre")
@RestController
public class GenresController {
    private final GenreService genreService;
    @Value("${environment.name}")
    private String test;

    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") long id) {
        return genreService.getGenre(id);
    }

    @PostMapping
    public ResponseEntity<?> createGenre(@RequestBody GenreCreateDto genreCreateDto) {
        genreService.addGenre(genreCreateDto.getName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGenre(@PathVariable("id") long id, @RequestBody GenreCreateDto newGenre) {
        genreService.updateGenre(id, newGenre.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGenre(@PathVariable("id") long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/test")
    public String test() {
        return test;
    }
}
