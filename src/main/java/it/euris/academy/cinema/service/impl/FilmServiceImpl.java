package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.FilmDto;
import it.euris.academy.cinema.data.model.Film;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNull;
import it.euris.academy.cinema.repository.FilmRepository;
import it.euris.academy.cinema.service.FilmService;


@Service
public class FilmServiceImpl implements FilmService{

  @Autowired
  private FilmRepository filmRepository;

  @Override
  public List<FilmDto> getAll() {
    return filmRepository.findAll().stream()
        .map(curFilm -> curFilm.toDto()).collect(Collectors.toList());
}

  @Override
  public FilmDto get(Long id) {
    Optional<Film> film = filmRepository.findById(id);
    if(film.isPresent()) {
        return film.get().toDto();
    }
    return null;
  }

  @Override
  public FilmDto add(FilmDto filmDto) {
    if(filmDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return filmRepository.save(filmDto.toModel()).toDto();
  }

  @Override
  public FilmDto update(FilmDto filmDto) {
    if(filmDto.getId() == null) {
      throw new IdMustNotBeNull();
    }
    return filmRepository.save(filmDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    filmRepository.deleteById(id);
    Optional<Film> deletedFilm = filmRepository.findById(id);
    if(deletedFilm.isEmpty()) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}
