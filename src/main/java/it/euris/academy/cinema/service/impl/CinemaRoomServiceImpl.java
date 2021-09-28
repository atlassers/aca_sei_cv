package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.CinemaRoomDto;
import it.euris.academy.cinema.data.model.CinemaRoom;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNull;
import it.euris.academy.cinema.repository.CinemaRoomRepository;
import it.euris.academy.cinema.service.CinemaRoomService;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService {
  @Autowired
  private CinemaRoomRepository cinemaRoomRepository;

  @Override
  public List<CinemaRoomDto> getAll() {
    return cinemaRoomRepository.findAll().stream()
        .map(curCinemaRoom -> curCinemaRoom.toDto()).collect(Collectors.toList());
}

  @Override
  public CinemaRoomDto get(Long id) {
    Optional<CinemaRoom> cinemaRoom = cinemaRoomRepository.findById(id);
    if(cinemaRoom.isPresent()) {
        return cinemaRoom.get().toDto();
    }
    return null;
  }

  @Override
  public CinemaRoomDto add(CinemaRoomDto cinemaRoomDto) {
    if(cinemaRoomDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return cinemaRoomRepository.save(cinemaRoomDto.toModel()).toDto();
  }

  @Override
  public CinemaRoomDto update(CinemaRoomDto cinemaRoomDto) {
    if(cinemaRoomDto.getId() == null) {
      throw new IdMustNotBeNull();
    }
    return cinemaRoomRepository.save(cinemaRoomDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    cinemaRoomRepository.deleteById(id);
    Optional<CinemaRoom> deletedCinemaRoom = cinemaRoomRepository.findById(id);
    if(deletedCinemaRoom.isEmpty()) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}
