package com.beshara.moviesdbapi.services;

import com.beshara.moviesdbapi.dao.GenreDao;
import com.beshara.moviesdbapi.exceptions.genre.GenreContainsMoviesException;
import com.beshara.moviesdbapi.exceptions.genre.GenreEmptyNameException;
import com.beshara.moviesdbapi.exceptions.genre.GenreNotFoundException;
import com.beshara.moviesdbapi.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreDao genreDao;

    @Autowired
    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    /**
     * Get all genres from the database
     *
     * @return All Genres
     */
    public List<Genre> getAllGenres() {
        return genreDao.findAll();
    }

    /**
     * Get the genre by ID
     *
     * @param id The id of the genre
     * @return The genre that corresponds to the provided id
     */
    public Genre getGenre(long id) {
        Optional<Genre> genre = genreDao.findById(id);
        if (genre.isEmpty()) throw new GenreNotFoundException();
        return genre.get();
    }

    /**
     * Add a genre to the database
     *
     * @param name The name of the category to be added
     * @return The created genre
     * @throws Exception Contains validation errors
     */
    public Genre addGenre(String name) {
        if (name.isEmpty()) throw new GenreEmptyNameException();

        Genre genre = new Genre(name);
        genreDao.saveAndFlush(genre);
        return genre;
    }

    /**
     * Update the name of an existing genre
     * @param id The ID of the genre
     * @param newName The New name of the genre
     * @return The New genre name
     */
    public Genre updateGenre(long id, String newName) {
        if (newName.isEmpty()) throw new GenreEmptyNameException();
        Optional<Genre> genre = genreDao.findById(id);
        if (genre.isEmpty()) {
            throw new GenreNotFoundException();
        }

        genre.get().setName(newName);
        genreDao.flush();
        return genre.get();
    }

    /**
     * Delete a genre from the database if no movies belong to it
     * @param id The id of the category to be deleted
     * @throws Exception Contains validation errors
     */
    public void deleteGenre(long id) {
        Optional<Genre> genre = genreDao.findById(id);
        if (genre.isEmpty()) {
            throw new GenreNotFoundException();
        }
        if (genre.get().getMovies().size() > 0) {
            throw new GenreContainsMoviesException();
        }
        genreDao.deleteById(id);
    }
}
