package es.uah.EdiMovie_MovieActors.dao;

import es.uah.EdiMovie_MovieActors.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMoviesJPA extends JpaRepository<Movie, Integer> {

  // Buscar por título (case insensitive)
  List<Movie> findByTitleContainingIgnoreCase(String title);

  // Buscar por género
  List<Movie> findByGenreContainingIgnoreCase(String genre);

  // Buscar por año
  List<Movie> findByYear(Integer year);

  // Buscar por director
  List<Movie> findByDirectorContainingIgnoreCase(String director);

  // Buscar por país
  List<Movie> findByCountryContainingIgnoreCase(String country);

  // Buscar por actor (usando una consulta JPQL)
  @Query("SELECT m FROM Movie m JOIN m.actors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :actorName, '%'))")
  List<Movie> findByActorName(@Param("actorName") String actorName);
  }