package it.euris.academy.cinema.data.dto;

import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.CinemaRoom;
import it.euris.academy.cinema.data.model.Customer;
import it.euris.academy.cinema.data.model.Film;
import it.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomerDto implements Dto{
  private String id;
  private String name;
  private String cinemaRoomId;
  private String filmId;
  
  @Override
  public Customer toModel() {
    return Customer.builder().id(UT.toLong(id)).name(name).cinemaRoom(new CinemaRoom(cinemaRoomId)).film(new Film(filmId)).build();
  }

}
