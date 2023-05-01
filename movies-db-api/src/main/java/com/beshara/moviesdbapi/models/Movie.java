package com.beshara.moviesdbapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Basic(optional = false)
    @Column(name = "title", nullable = false)
    private String title;

    @Basic(optional = false)
    @Column(name = "overview", nullable = false)
    private String overview;

    @Basic(optional = false)
    @Column(name = "popularity", nullable = false)
    private Double popularity;

    @Basic(optional = false)
    @Column(name = "releaseDate", nullable = false)
    private Date releaseDate;

    @Basic(optional = false)
    @Column(name = "backdropPath", nullable = false)
    private String backdropPath;

    @Basic(optional = false)
    @Column(name = "posterPath", nullable = false)
    private String posterPath;

    @Basic(optional = false)
    @Column(name = "rating", nullable = false)
    private Double rating;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Movie_Genres",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private final Set<Genre> genres = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Movie_Creators",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "creator_id")}
    )
    private final Set<Creator> creators = new HashSet<>();

    public Movie() {
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
        genre.getMovies().add(this);
    }

    public void addCreator(Creator creator) {
        this.creators.add(creator);
        creator.getMovies().add(this);
    }

    public void removeGenre(long genreId) {
        Genre genre = this.genres.stream().filter(t -> t.getId() == genreId).findFirst().orElse(null);
        if (genre != null) {
            this.genres.remove(genre);
            genre.getMovies().remove(this);
        }
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

    public Set<Genre> getGenres() {
        return genres;
    }

    public Set<Creator> getCreators() {
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
