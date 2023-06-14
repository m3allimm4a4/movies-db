package com.beshara.moviesdbapi.mapper;

import com.beshara.moviesdbapi.models.dto.movie.MovieCreateDto;
import com.beshara.moviesdbapi.models.dto.movie.MovieSearchDto;
import com.beshara.moviesdbapi.models.dbo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;

import java.util.List;

@Mapper
public interface MovieMapper {
    List<MovieSearchDto> search(@NonNull String searchString);
    Movie findById(@NonNull long id);
    void insert(@NonNull MovieCreateDto movie);
}
