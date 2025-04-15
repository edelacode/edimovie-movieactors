package es.uah.EdiMovie_MovieActors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor", nullable = false)
    private Integer idActor;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "birthCountry", nullable = false, length = 100)
    private String birthCountry;

    @Column(name = "photo")
    private String photo;

    @ManyToMany
    /*
    @JoinTable(name = "movies_actors",
            joinColumns = @JoinColumn(name = "idActor"),
            inverseJoinColumns = @JoinColumn(name = "idMovie"))
    Esto no funciona, utilizamos lo siguiente:
    */
    @JoinTable(name = "movies_actors",
            joinColumns = { @JoinColumn(name = "idActor", referencedColumnName = "idActor") },
            inverseJoinColumns = { @JoinColumn(name = "idMovie", referencedColumnName = "idMovie")  }
    )
    @JsonIgnoreProperties("actors")
    private List<Movie> movies;

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActor) {
        this.idActor = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (movie != null) {
            getMovies().add(movie);
            movie.addActor(this);
        }
    }

    public void removeMovie(Movie movie) {
        if (movie != null) {
            movie.removeActor(this);
            getMovies().remove(movie);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(idActor, actor.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idActor);
    }
}