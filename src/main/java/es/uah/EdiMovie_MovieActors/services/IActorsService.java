package es.uah.EdiMovie_MovieActors.services;

import es.uah.EdiMovie_MovieActors.model.Actor;

import java.util.List;

public interface IActorsService {

    List<Actor> getActors();

    Actor getActorById(Integer idActor);

    List<Actor> getActorsByName(String name);

    List<Actor> getActorsByBirthCountry(String birthCountry);

    void createActor(Actor actor);

    void updateActor(Actor actor);

    void deleteActor(Integer idActor);

}
