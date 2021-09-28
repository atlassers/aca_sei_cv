package it.euris.academy.cinema.data.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.cinema.data.archetype.Model;
import it.euris.academy.cinema.data.dto.FilmDto;
import it.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table(name="film")
@Entity
public class Film implements Model{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="title")
  private String title;
  
  @Column(name="director")
  private String director;
  
  @OneToMany(mappedBy = "film")
  private List<Customer> customers;
  
  public Film(String filmId){
    if(filmId != null) {
      this.id = Long.parseLong(filmId);
    }
  }
  
  @Override
  public FilmDto toDto() {
    return FilmDto.builder().id(UT.toString(id))
        .title(title)
        .director(director)
        .build();
  }

}
