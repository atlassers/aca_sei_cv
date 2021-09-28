package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.FilmDto;

public interface FilmService {
  public List<FilmDto> getAll();

  public FilmDto get(Long id);
  
  public FilmDto add(FilmDto studentDto);

  public FilmDto update(FilmDto studentDto);
  
  public Boolean delete(Long id);
  
}
