package com.beshara.moviesdbapi.mapper;

import com.beshara.moviesdbapi.models.dbo.Genre;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;

import java.util.List;

@Mapper
public interface GenreMapper {
    List<Genre> findAll();
    List<Genre> findAllById(@NonNull List<Long> ids);
    Genre findById(@NonNull long id);
    void insertGenre(@NonNull String name);
    void updateGenre(@NonNull String name);
    void deleteGenre(@NonNull long id);
}
