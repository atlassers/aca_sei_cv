package it.euris.academy.cinema.data.model.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FilmScreeningKey implements Serializable {
  private static final long serialVersionUID = 1L;
  
  @Column(name = "film_id")
  Long productId;
  
  @Column(name = "cinema_room_id")
  Long cinemaRoomId;
}
