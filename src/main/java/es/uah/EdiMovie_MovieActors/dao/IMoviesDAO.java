package es.uah.EdiMovie_MovieActors.dao;

import es.uah.EdiMovie_MovieActors.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesDAO {

    List<Movie> getMovies();

    Movie getMovieById(Integer idMovie);

    List<Movie> getMoviesByTitle(String title);

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> getMoviesByYear(Integer year);

    List<Movie> getMoviesByDirector(String director);

    List<Movie> getMoviesByCountry(String country);

    List<Movie> getMoviesByActorName(String actorName);

    void addMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(Integer idMovie);

}
