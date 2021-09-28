package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.CinemaRoomDto;

public interface CinemaRoomService {

  public List<CinemaRoomDto> getAll();

  public CinemaRoomDto get(Long id);
  
  public CinemaRoomDto add(CinemaRoomDto studentDto);

  public CinemaRoomDto update(CinemaRoomDto studentDto);
  
  public Boolean delete(Long id);
}
