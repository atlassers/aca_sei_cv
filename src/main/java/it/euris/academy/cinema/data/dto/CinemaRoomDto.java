package it.euris.academy.cinema.data.dto;

import java.util.List;
import it.euris.academy.cinema.data.archetype.Dto;
import it.euris.academy.cinema.data.model.CinemaRoom;
import it.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CinemaRoomDto implements Dto{
  
  private String id;
  private String seats;
  private List<CustomerDto> customers;
  
  @Override
  public CinemaRoom toModel() {
    return CinemaRoom.builder().id(UT.toLong(id)).seats(UT.toLong(seats)).build();
  }
}
