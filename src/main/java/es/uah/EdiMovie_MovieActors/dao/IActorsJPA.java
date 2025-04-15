package es.uah.EdiMovie_MovieActors.dao;

import es.uah.EdiMovie_MovieActors.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorsJPA extends JpaRepository<Actor, Integer> {
  //Buscar por nombre del actor
  List<Actor> findByNameContainingIgnoreCase (String name);

  //Buscar por nacionalidad (país de nacimiento)
  List<Actor> findByBirthCountryContainingIgnoreCase(String birthCountry);

}