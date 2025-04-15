package es.uah.EdiMovie_MovieActors.services.impl;

import es.uah.EdiMovie_MovieActors.dao.*;
import es.uah.EdiMovie_MovieActors.model.*;
import es.uah.EdiMovie_MovieActors.services.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService {

    @Autowired
    private IMoviesDAO moviesDAO;

    @Autowired
    private IActorsDAO actorsDAO;

    @Override
    public List<Movie> getMovies() {
        return moviesDAO.getMovies();
    }

    @Override
    public Movie getMovieById(Integer idMovie) {
        return moviesDAO.getMovieById(idMovie);
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        return moviesDAO.getMoviesByTitle(title);
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return moviesDAO.getMoviesByGenre(genre);
    }

    @Override
    public List<Movie> getMoviesByYear(Integer year) {
        return moviesDAO.getMoviesByYear(year);
    }

    @Override
    public List<Movie> getMoviesByDirector(String director) {
        return moviesDAO.getMoviesByDirector(director);
    }

    @Override
    public List<Movie> getMoviesByCountry(String country) {
        return moviesDAO.getMoviesByCountry(country);
    }

    @Override
    public List<Movie> getMoviesByActorName(String actorName) {
        return moviesDAO.getMoviesByActorName(actorName);
    }

    @Override
    public void createMovie(Movie movie, List<Integer> idActors) {
        List<Actor> actors = actorsDAO.getActorsByIds(idActors);

        movie.setActors(actors);
        actors.forEach(actor -> actor.getMovies().add(movie));

        moviesDAO.addMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie, List<Integer> idActors) {
        // Recuperar la película existente desde la base de datos
        Movie existingMovie = moviesDAO.getMovieById(movie.getIdMovie());
        if (existingMovie == null) {
            throw new IllegalArgumentException("Película no encontrada con ID: " + movie.getIdMovie());
        }

        // Actualizar los datos básicos de la película
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setYear(movie.getYear());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setCountry(movie.getCountry());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setCoverImage(movie.getCoverImage());
        existingMovie.setSynopsis(movie.getSynopsis());

        // Recuperar los actores correspondientes a los IDs proporcionados
        List<Actor> newActors = idActors.stream()
                .map(actorsDAO::getActorById)
                .filter(actor -> actor != null)
                .toList();

        // Limpiar las relaciones existentes de la película con los actores
        for (Actor actor : new ArrayList<>(existingMovie.getActors())) {
            actor.getMovies().remove(existingMovie);
        }
        existingMovie.getActors().clear();

        // Establecer las nuevas relaciones
        existingMovie.getActors().addAll(newActors);
        for (Actor actor : newActors) {
            actor.getMovies().add(existingMovie);
        }

        // Persistir los cambios
        moviesDAO.updateMovie(existingMovie);
    }

    @Override
    public void deleteMovie(Integer idMovie) {
        // Recuperar al actor desde la base de datos
        Movie movie = moviesDAO.getMovieById(idMovie);
        if (movie == null) {
            throw new IllegalArgumentException("Pelicula no encontrado con ID: " + idMovie);
        }

        // Eliminar la pelicula de los actores asociados
        for (Actor actor : new ArrayList<>(movie.getActors())) {
            actor.getMovies().remove(movie);
            movie.getActors().remove(actor);
        }

        // Ahora eliminar la pelicula de la base de datos
        moviesDAO.deleteMovie(idMovie);
    }
}
