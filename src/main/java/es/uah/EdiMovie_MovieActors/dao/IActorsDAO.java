package es.uah.EdiMovie_MovieActors.dao;

import es.uah.EdiMovie_MovieActors.model.Actor;
import java.util.List;

public interface IActorsDAO {

    List<Actor> getActors();

    Actor getActorById(Integer idActor);

    List<Actor> getActorsByName(String name);

    List<Actor> getActorsByBirthCountry(String birthCountry);

    List<Actor> getActorsByIds(List<Integer> idsActor);

    void addActor(Actor actor);

    void updateActor(Actor actor);

    void deleteActor(Integer idActor);
}
