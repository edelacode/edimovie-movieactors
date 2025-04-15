package es.uah.EdiMovie_MovieActors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovie", nullable = false)
    private Integer idMovie;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "genre", nullable = false, length = 100)
    private String genre;

    @Column(name = "synopsis", nullable = false)
    private String synopsis;

    @Column(name = "coverImage")
    private String coverImage;

    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private List<Actor> actors;

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActors().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActors().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(idMovie, movie.idMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idMovie);
    }
}