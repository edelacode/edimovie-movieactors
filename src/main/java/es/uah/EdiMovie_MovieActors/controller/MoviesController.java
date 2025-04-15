package es.uah.EdiMovie_MovieActors.controller;

import es.uah.EdiMovie_MovieActors.dto.MovieRequest;
import es.uah.EdiMovie_MovieActors.model.Movie;
import es.uah.EdiMovie_MovieActors.services.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private IMoviesService moviesService;

    @GetMapping
    public List<Movie> getMovies() {
        return moviesService.getMovies();
    }

    @GetMapping("/{idMovie}")
    public Movie getMovieById(@PathVariable Integer idMovie) {
        return moviesService.getMovieById(idMovie);
    }

    @GetMapping("/search/title/{title}")
    public List<Movie> searchMoviesByTitle(@PathVariable("title") String title) {
        return moviesService.getMoviesByTitle(title);
    }

    @GetMapping("/search/genre/{genre}")
    public List<Movie> searchMoviesByGenre(@PathVariable("genre") String genre) {
        return moviesService.getMoviesByGenre(genre);
    }

    @GetMapping("/search/year/{year}")
    public List<Movie> searchMoviesByYear(@PathVariable("year") Integer year) {
        return moviesService.getMoviesByYear(year);
    }

    @GetMapping("/search/director/{director}")
    public List<Movie> searchMoviesByDirector(@PathVariable("director") String director) {
        return moviesService.getMoviesByDirector(director);
    }

    @GetMapping("/search/country/{country}")
    public List<Movie> searchMoviesByCountry(@PathVariable("country") String country) {
        return moviesService.getMoviesByCountry(country);
    }

    @GetMapping("/search/actor/{actorName}")
    public ResponseEntity<List<Movie>> getMoviesByActorName(@PathVariable("actorName") String actorName) {
        List<Movie> movies = moviesService.getMoviesByActorName(actorName);
        if (movies != null && !movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createMovie(@RequestBody MovieRequest movieRequest) {
        moviesService.createMovie(movieRequest.getMovie(), movieRequest.getActorIds());
        return ResponseEntity.ok("Película creada con éxito.");
    }

    @PutMapping
    public ResponseEntity<String> updateMovie(@RequestBody MovieRequest movieRequest) {
        moviesService.updateMovie(movieRequest.getMovie(), movieRequest.getActorIds());
        return ResponseEntity.ok("Película actualizada con éxito.");
    }

    @DeleteMapping("/{idMovie}")
    public ResponseEntity<String> deleteMovie(@PathVariable("idMovie") Integer idMovie) {
        moviesService.deleteMovie(idMovie);
        return ResponseEntity.ok("Película eliminada con éxito.");
    }
}
