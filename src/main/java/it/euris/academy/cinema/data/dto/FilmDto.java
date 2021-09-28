package it.euris.academy.cinema.data.dto;

import java.util.List;
import it.euris.academy.cinema.data.archetype.Dto;
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

  public class FilmDto implements Dto{
    private String id;
    private String title;
    private String director;
    private List<CustomerDto> customers;
  @Override
  public Film toModel() {
    return Film.builder().id(UT.toLong(id)).title(title).director(director).build();
  }

}
