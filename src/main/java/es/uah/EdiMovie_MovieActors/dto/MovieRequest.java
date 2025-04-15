package es.uah.EdiMovie_MovieActors.dto;

import es.uah.EdiMovie_MovieActors.model.Movie;

import java.util.List;

public class MovieRequest {
    private Movie movie;
    private List<Integer> actorIds;

    // Getters y Setters
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Integer> getActorIds() {
        return actorIds;
    }

    public void setActorIds(List<Integer> actorIds) {
        this.actorIds = actorIds;
    }
}
