package es.uah.EdiMovie_MovieActors.dao.impl;

import es.uah.EdiMovie_MovieActors.dao.*;
import es.uah.EdiMovie_MovieActors.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MoviesDAOImpl implements IMoviesDAO {

    @Autowired
    private IMoviesJPA movieJPA;

    @Override
    public List<Movie> getMovies() {
        return movieJPA.findAll();
    }

    @Override
    public Movie getMovieById(Integer idMovie) {
        Optional<Movie> optionalMovie = movieJPA.findById(idMovie);
        return optionalMovie.orElse(null);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        return movieJPA.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movieJPA.findByGenreContainingIgnoreCase(genre);
    }

    @Override
    public List<Movie> getMoviesByYear(Integer year) {
        return movieJPA.findByYear(year);
    }

    @Override
    public List<Movie> getMoviesByDirector(String director) {
        return movieJPA.findByDirectorContainingIgnoreCase(director);
    }

    @Override
    public List<Movie> getMoviesByCountry(String country) {
        return movieJPA.findByCountryContainingIgnoreCase(country);
    }

    @Override
    public List<Movie> getMoviesByActorName(String actorName) {
        return movieJPA.findByActorName(actorName);
    }

    @Override
    public void addMovie(Movie movie) {
        movieJPA.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieJPA.save(movie);
    }

    @Override
    public void deleteMovie(Integer idMovie) {
        movieJPA.deleteById(idMovie);
    }
}
