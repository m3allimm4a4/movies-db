package com.beshara.moviesdbapi.dao;

import com.beshara.moviesdbapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String query);
}
