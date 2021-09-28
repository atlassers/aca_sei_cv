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
import it.euris.academy.cinema.data.dto.CinemaRoomDto;
import it.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table(name="cinema_room")
@Entity

public class CinemaRoom implements Model{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="number_seats")
  private Long seats;
  
  @OneToMany(mappedBy = "cinemaRoom")
  private List<Customer> customers;
  
  public CinemaRoom(String cinemaRoomId){
    if(cinemaRoomId != null) {
      this.id = Long.parseLong(cinemaRoomId);
    }
  }
  
  @Override
  public CinemaRoomDto toDto() {
    return CinemaRoomDto.builder().id(UT.toString(id)).seats(UT.toString(seats)).build();
  }
}
