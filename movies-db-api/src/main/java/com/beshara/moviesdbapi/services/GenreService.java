package com.beshara.moviesdbapi.services;

import com.beshara.moviesdbapi.dao.GenreDao;
import com.beshara.moviesdbapi.exceptions.genre.GenreEmptyNameException;
import com.beshara.moviesdbapi.exceptions.genre.GenreNotFoundException;
import com.beshara.moviesdbapi.models.dbo.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreDao genreDao;

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
     * @throws GenreNotFoundException if genre is not found
     */
    public Genre getGenre(long id) {
        Genre genre = genreDao.findById(id);
        if (genre == null) throw new GenreNotFoundException();
        return genre;
    }

    /**
     * Add a genre to the database
     *
     * @param name The name of the category to be added
     * @throws GenreEmptyNameException if the name is empty
     */
    public void addGenre(String name) {
        genreDao.insert(name);
    }

    /**
     * Update the name of an existing genre
     *
     * @param id      The ID of the genre
     * @param newName The New name of the genre
     * @throws GenreEmptyNameException if the new genre name is empty
     * @throws GenreNotFoundException  if the genre doesn't exist
     */
    public void updateGenre(long id, String newName) {
        if (newName.isEmpty()) throw new GenreEmptyNameException();

        Genre genre = genreDao.findById(id);
        if (genre == null) throw new GenreNotFoundException();

        genreDao.update(newName);
    }

    /**
     * Delete a genre from the database if no movies belong to it
     *
     * @param id The id of the category to be deleted
     * @throws GenreNotFoundException if the genre was not found
     */
    public void deleteGenre(long id) {
        Genre genre = genreDao.findById(id);
        if (genre == null) throw new GenreNotFoundException();

        genreDao.deleteById(id);
    }
}
