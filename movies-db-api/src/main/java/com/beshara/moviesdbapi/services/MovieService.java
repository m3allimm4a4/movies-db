package com.beshara.moviesdbapi.services;

import com.beshara.moviesdbapi.dao.MovieDao;
import com.beshara.moviesdbapi.exceptions.movie.MovieNotFoundException;
import com.beshara.moviesdbapi.exceptions.movie.MovieSearchEmptyQueryException;
import com.beshara.moviesdbapi.models.dbo.Movie;
import com.beshara.moviesdbapi.models.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.models.dto.movie.MovieSearchDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieDao movieDao;
    private final ModelMapper modelMapper;

    public MovieService(MovieDao movieDao, ModelMapper modelMapper) {
        this.movieDao = movieDao;
        this.modelMapper = modelMapper;
    }

    /**
     * Get all movie details
     *
     * @param id The ID of the movie
     * @return The movie that corresponds to the provided id
     * throws MovieNotFoundException
     */
    public Movie getMovieDetails(long id) {
        Movie movie = movieDao.findById(id);
        if (movie == null) {
            throw new MovieNotFoundException();
        }
        return movie;
    }

    /**
     * Search for the movie in the database
     *
     * @param query The movie name to search for
     * @return A list of movies that have a title matching the query
     * @throws MovieSearchEmptyQueryException if the query is empty
     */
    public List<MovieSearchDto> searchMovies(String query) {
        if (query.isEmpty()) {
            throw new MovieSearchEmptyQueryException();
        }

        return movieDao.search(query.trim());
    }

    /**
     * Add a movie to the database
     *
     * @param movieDto The object that contains the required info to add a movie to the database
     */
    public void addMovie(MovieCreateDto movieDto) {
        movieDao.insert(movieDto);
    }
}
