package es.uah.EdiMovie_MovieActors.controller;

import es.uah.EdiMovie_MovieActors.model.Actor;
import es.uah.EdiMovie_MovieActors.services.IActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    private IActorsService actorsService;

    @GetMapping
    public List<Actor> getActors() {
        return actorsService.getActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Integer id) {
        return actorsService.getActorById(id);
    }

    @GetMapping("/search/name/{name}")
    public List<Actor> searchActorsByName(@PathVariable("name") String name) {
        return actorsService.getActorsByName(name);
    }

    @GetMapping("/search/country/{country}")
    public List<Actor> searchActorsByCountry(@PathVariable("country") String country) {
        return actorsService.getActorsByBirthCountry(country);
    }

    @PostMapping
    public ResponseEntity<String> createActor(@RequestBody Actor actor) {
        actorsService.createActor(actor);
        return ResponseEntity.ok("Actor creado con éxito.");
    }

    @PutMapping
    public ResponseEntity<String> updateActor(@RequestBody Actor actor) {
        actorsService.updateActor(actor);
        return ResponseEntity.ok("Actor actualizado con éxito.");
    }

    @DeleteMapping("/{idActor}")
    public ResponseEntity<String> deleteActor(@PathVariable Integer idActor) {
        actorsService.deleteActor(idActor);
        return ResponseEntity.ok("Actor eliminado con éxito.");
    }
}
