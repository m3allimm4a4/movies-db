package com.beshara.moviesdbapi.dao;

import com.beshara.moviesdbapi.models.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.models.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.mapper.MovieMapper;
import com.beshara.moviesdbapi.models.dbo.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDao {
    private final MovieMapper movieMapper;

    public MovieDao(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<MovieSearchDto> search(String searchString) {
        return movieMapper.search("%" + searchString + "%");
    }

    public Movie findById(long id) {
        return movieMapper.findById(id);
    }
    public void insert(MovieCreateDto movie){
        movieMapper.insert(movie);
    }
}
