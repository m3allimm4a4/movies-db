package com.beshara.moviesdbapi.dao.genre;

import com.beshara.moviesdbapi.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {
}
