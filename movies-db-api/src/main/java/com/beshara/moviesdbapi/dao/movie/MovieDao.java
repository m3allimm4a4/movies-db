package com.beshara.moviesdbapi.dao.movie;

import com.beshara.moviesdbapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String query);

    @Query(value = "SELECT * FROM movie WHERE title LIKE :query", nativeQuery = true)
    List<Movie> search(@Param("query") String query);
}
