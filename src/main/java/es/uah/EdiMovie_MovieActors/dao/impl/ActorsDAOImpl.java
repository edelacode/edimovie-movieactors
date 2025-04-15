package es.uah.EdiMovie_MovieActors.dao.impl;

import es.uah.EdiMovie_MovieActors.dao.*;
import es.uah.EdiMovie_MovieActors.model.Actor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorsDAOImpl implements IActorsDAO {

    @Autowired
    private IActorsJPA actorJPA;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Actor> getActors() {
        return actorJPA.findAll();
    }

    @Override
    public Actor getActorById(Integer idActor) {
        Optional<Actor> optionalActor = actorJPA.findById(idActor);
        return optionalActor.orElse(null);
    }

    @Override
    public List<Actor> getActorsByName(String name) {
        return actorJPA.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Actor> getActorsByBirthCountry(String birthCountry) {
        return actorJPA.findByBirthCountryContainingIgnoreCase(birthCountry);
    }

    @Override
    public List<Actor> getActorsByIds(List<Integer> idActors) {
        return entityManager.createQuery("SELECT a FROM Actor a WHERE a.idActor IN :ids", Actor.class)
                .setParameter("ids", idActors)
                .getResultList();
    }

    @Override
    public void addActor(Actor actor) {
        actorJPA.save(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        Actor existingActor = actorJPA.findById(actor.getIdActor())
                .orElseThrow(() -> new EntityNotFoundException("Actor no encontrado"));

        existingActor.setName(actor.getName());
        existingActor.setBirthDate(actor.getBirthDate());
        existingActor.setBirthCountry(actor.getBirthCountry());
        existingActor.setPhoto(actor.getPhoto());

        if (actor.getMovies() != null) {
            existingActor.setMovies(actor.getMovies());
        }

        actorJPA.save(existingActor);
    }

    @Override
    public void deleteActor(Integer idActor) {
        actorJPA.deleteById(idActor);
    }
}
