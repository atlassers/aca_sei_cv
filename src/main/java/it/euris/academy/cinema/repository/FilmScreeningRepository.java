package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.CinemaRoom;

public interface FilmScreeningRepository extends JpaRepository<CinemaRoom, Long> {

}
