package com.beshara.moviesdbapi.models.dbo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Movie {
    private long id;
    private String title;
    private String overview;
    private Double popularity;
    private Date releaseDate;
    private String backdropPath;
    private String posterPath;
    private Double rating;
    private final List<Genre> genres = new ArrayList<>();
    private final List<Creator> creators = new ArrayList<>();

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", backdropPath='" + backdropPath + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", rating=" + rating +
                ", genres=" + genres +
                ", creators=" + creators +
                '}';
    }
}
