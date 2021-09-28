package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.CinemaRoom;

public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Long>{

}
