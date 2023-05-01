package com.beshara.moviesdbapi.dao;

import com.beshara.moviesdbapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {
}
