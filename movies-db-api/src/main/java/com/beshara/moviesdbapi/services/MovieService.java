package com.beshara.moviesdbapi.services;

import com.beshara.moviesdbapi.dao.CreatorDao;
import com.beshara.moviesdbapi.dao.GenreDao;
import com.beshara.moviesdbapi.dao.MovieDao;
import com.beshara.moviesdbapi.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.exceptions.movie.MovieNotFoundException;
import com.beshara.moviesdbapi.models.Creator;
import com.beshara.moviesdbapi.models.Genre;
import com.beshara.moviesdbapi.models.Movie;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Movie getMovieDetails(long id) {
        Optional<Movie> movie = movieDao.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException();
        }
        return movie.orElseThrow();
    }

    public List<MovieSearchDto> getMovies(String query) {
        List<Movie> movies = movieDao.findByTitleContaining(query);
        List<MovieSearchDto> moviesList = modelMapper.map(movies, new TypeToken<List<MovieSearchDto>>(){}.getType());
        return moviesList;
    }

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
