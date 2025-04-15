package es.uah.EdiMovie_MovieActors.services;

import es.uah.EdiMovie_MovieActors.model.Movie;

import java.util.List;

public interface IMoviesService {

    List<Movie> getMovies();

    Movie getMovieById(Integer idMovie);

    List<Movie> getMoviesByTitle(String title);

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> getMoviesByYear(Integer year);

    List<Movie> getMoviesByDirector(String director);

    List<Movie> getMoviesByCountry(String country);

    List<Movie> getMoviesByActorName(String actorName);

    void createMovie(Movie movie, List<Integer> idActors);

    void updateMovie(Movie movie, List<Integer> idActors);

    void deleteMovie(Integer idMovie);

}
