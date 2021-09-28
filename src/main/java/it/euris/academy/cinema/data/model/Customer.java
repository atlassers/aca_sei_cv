package it.euris.academy.cinema.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.CustomerDto;
import it.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table(name="customer")
@Entity
public class Customer implements Model{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="name")
  private String name;
  
  @ManyToOne
  @JoinColumn(name="film_id", nullable = false)
  private Film film;
  
  @ManyToOne
  @JoinColumn(name = "cinema_room_id", nullable = false)
  private CinemaRoom cinemaRoom;

  @Override
  public CustomerDto toDto() {
   return CustomerDto.builder().id(UT.toString(id))
       .name(name)
       .cinemaRoomId(cinemaRoom.getId().toString())
       .filmId(film.getId().toString())
       .build();
  }

}
