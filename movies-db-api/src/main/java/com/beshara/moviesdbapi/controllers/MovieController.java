package com.beshara.moviesdbapi.controllers;

import com.beshara.moviesdbapi.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.exceptions.movie.MovieNotFoundException;
import com.beshara.moviesdbapi.models.Movie;
import com.beshara.moviesdbapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/movie")
@RestController
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/searchMovies")
    public List<MovieSearchDto> searchMovies(@RequestParam("query") String query) {
        return movieService.getMovies(query);
    }

    @GetMapping("/getMovieDetails/{id}")
    public Movie getMovieDetails(@PathVariable("id") int id) {
        try {
            return movieService.getMovieDetails(id);
        } catch (MovieNotFoundException e) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Movie createMovie(@RequestBody MovieCreateDto movieCreateDto) {
        return movieService.addMovie(movieCreateDto);
    }
}
