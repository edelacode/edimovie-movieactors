package es.uah.EdiMovie_MovieActors.services.impl;

import es.uah.EdiMovie_MovieActors.dao.IActorsDAO;
import es.uah.EdiMovie_MovieActors.model.Actor;
import es.uah.EdiMovie_MovieActors.model.Movie;
import es.uah.EdiMovie_MovieActors.services.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    @Autowired
    private IActorsDAO actorsDAO;

    @Override
    public List<Actor> getActors() {
        return actorsDAO.getActors();
    }

    @Override
    public Actor getActorById(Integer idActor) {
        return actorsDAO.getActorById(idActor);
    }

    @Override
    public List<Actor> getActorsByName(String name) {
        return actorsDAO.getActorsByName(name);
    }

    @Override
    public List<Actor> getActorsByBirthCountry(String birthCountry) {
        return actorsDAO.getActorsByBirthCountry(birthCountry);
    }

    @Override
    public void createActor(Actor actor) {
        actorsDAO.addActor(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorsDAO.updateActor(actor);
    }

    @Override
    public void deleteActor(Integer idActor) {
        // Recuperar al actor desde la base de datos
        Actor actor = actorsDAO.getActorById(idActor);
        if (actor == null) {
            throw new IllegalArgumentException("Actor no encontrado con ID: " + idActor);
        }

        // Eliminar el actor de las películas asociadas
        for (Movie movie : new ArrayList<>(actor.getMovies())) {
            movie.getActors().remove(actor);
            actor.getMovies().remove(movie);
        }

        // Ahora eliminar al actor de la base de datos
        actorsDAO.deleteActor(idActor);
    }
}
