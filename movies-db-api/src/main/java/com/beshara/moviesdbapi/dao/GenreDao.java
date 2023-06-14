package com.beshara.moviesdbapi.dao;

import com.beshara.moviesdbapi.mapper.GenreMapper;
import com.beshara.moviesdbapi.models.dbo.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDao {
    private final GenreMapper genreMapper;

    public GenreDao(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public List<Genre> findAll() {
        return genreMapper.findAll();
    }

    public Genre findById(long id) {
        return genreMapper.findById(id);
    }

    public void insert(String name) {
        genreMapper.insertGenre(name);
    }

    public void update(String name) {
        genreMapper.updateGenre(name);
    }

    public void deleteById(long id) {
        genreMapper.deleteGenre(id);
    }
}