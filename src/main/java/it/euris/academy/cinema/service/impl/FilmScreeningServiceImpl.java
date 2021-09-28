//package it.euris.academy.cinema.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import it.euris.academy.cinema.data.dto.FilmScreeningDto;
//import it.euris.academy.cinema.data.model.FilmScreening;
//import it.euris.academy.cinema.exception.IdMustBeNullException;
//import it.euris.academy.cinema.exception.IdMustNotBeNull;
//import it.euris.academy.cinema.repository.FilmScreeningRepository;
//import it.euris.academy.cinema.service.FilmScreeningService;
//
//@Service
//public class FilmScreeningServiceImpl implements FilmScreeningService{
//  @Autowired
//  private FilmScreeningRepository filmScreeningRepository;
//
//  @Override
//  public List<FilmScreeningDto> getAll() {
//    return filmScreeningRepository.findAll().stream()
//        .map(curFilmScreening -> curFilmScreening.toDto()).collect(Collectors.toList());
//}
//
//  @Override
//  public FilmScreeningDto get(Long id) {
//    Optional<FilmScreening> filmScreening = filmScreeningRepository.findById(id);
//    if(filmScreening.isPresent()) {
//        return filmScreening.get().toDto();
//    }
//    return null;
//  }
//
//  @Override
//  public FilmScreeningDto add(FilmScreeningDto filmScreeningDto) {
//    if(filmScreeningDto.getId() != null) {
//      throw new IdMustBeNullException();
//    }
//    return filmScreeningRepository.save(filmScreeningDto.toModel()).toDto();
//  }
//
//  @Override
//  public FilmScreeningDto update(FilmScreeningDto filmScreeningDto) {
//    if(filmScreeningDto.getId() == null) {
//      throw new IdMustNotBeNull();
//    }
//    return filmScreeningRepository.save(filmScreeningDto.toModel()).toDto();
//  }
//
//  @Override
//  public Boolean delete(Long id) {
//    filmScreeningRepository.deleteById(id);
//    Optional<FilmScreening> deletedFilmScreening = filmScreeningRepository.findById(id);
//    if(deletedFilmScreening.isEmpty()) {
//      return Boolean.TRUE;
//    }
//    return Boolean.FALSE;
//  }
//}
