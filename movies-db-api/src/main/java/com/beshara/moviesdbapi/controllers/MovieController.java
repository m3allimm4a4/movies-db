package com.beshara.moviesdbapi.controllers;

import com.beshara.moviesdbapi.models.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.models.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.models.dbo.Movie;
import com.beshara.moviesdbapi.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/movie")
@CrossOrigin(origins = "*")
@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/searchMovies")
    public List<MovieSearchDto> searchMovies(@RequestParam("query") String query) {
        return movieService.searchMovies(query);
    }

    @GetMapping("/getMovieDetails/{id}")
    public Movie getMovieDetails(@PathVariable("id") int id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody MovieCreateDto movieCreateDto) {
        movieService.addMovie(movieCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
