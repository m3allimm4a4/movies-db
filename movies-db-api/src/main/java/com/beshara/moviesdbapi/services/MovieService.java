package com.beshara.moviesdbapi.services;

import com.beshara.moviesdbapi.dao.creator.CreatorDao;
import com.beshara.moviesdbapi.dao.genre.GenreDao;
import com.beshara.moviesdbapi.dao.movie.MovieDao;
import com.beshara.moviesdbapi.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.exceptions.movie.MovieNotFoundException;
import com.beshara.moviesdbapi.exceptions.movie.MovieSearchEmptyQueryException;
import com.beshara.moviesdbapi.models.Creator;
import com.beshara.moviesdbapi.models.Genre;
import com.beshara.moviesdbapi.models.Movie;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieDao movieDao;
    private final GenreDao genreDao;
    private final CreatorDao creatorDao;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieService(MovieDao movieDao, GenreDao genreDao, CreatorDao creatorDao, ModelMapper modelMapper) {
        this.movieDao = movieDao;
        this.genreDao = genreDao;
        this.creatorDao = creatorDao;
        this.modelMapper = modelMapper;
    }

    /**
     * Get all movie details
     * @param id The ID of the movie
     * @return The movie that corresponds to the provided id
     * throws MovieNotFoundException
     */
    public Movie getMovieDetails(long id) {
        Optional<Movie> movie = movieDao.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException();
        }
        return movie.get();
    }

    /**
     * Search for the movie in the database
     * @param query The movie name to search for
     * @return A list of movies that have a title matching the query
     * @throws MovieSearchEmptyQueryException
     */
    public List<MovieSearchDto> searchMovies(String query) {
        if (query.isEmpty()) {
            throw new MovieSearchEmptyQueryException();
        }

        String queryString = query.trim();
        queryString = "%" + queryString + "%";
        List<Movie> movies = movieDao.search(queryString);
        List<MovieSearchDto> moviesList = modelMapper.map(movies, new TypeToken<List<MovieSearchDto>>(){}.getType());

        return moviesList;
    }

    /**
     * Add a movie to the database
     * @param movieDto The object that contains the required info to add a movie to the database
     * @return The created movie
     */
    public Movie addMovie(MovieCreateDto movieDto) {
        Movie movie = this.modelMapper.map(movieDto, Movie.class);
        List<Long> genreIds = movieDto.getGenreIds();
        List<Long> creatorIds = movieDto.getCreatorIds();

        if (genreIds.size() != 0) {
            List<Genre> genres = genreDao.findAllById(genreIds);
            genres.forEach(movie::addGenre);
        }
        if (creatorIds.size() != 0) {
            List<Creator> creators = creatorDao.findAllById(creatorIds);
            creators.forEach(movie::addCreator);
        }

        movieDao.saveAndFlush(movie);
        return movie;
    }
}
