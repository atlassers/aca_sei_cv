//package it.euris.academy.cinema.controller;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import it.euris.academy.cinema.data.dto.FilmScreeningDto;
//import it.euris.academy.cinema.service.FilmScreeningService;
//
//public class FilmScreeningController {
//  @Autowired
//  FilmScreeningService filmScreeningService;
//  
//  @GetMapping("/v1")
//  public List<FilmScreeningDto> getAll() {
//      return filmScreeningService.getAll();
//  }
//
//  //localhost:8100/uno/filmScreenings/v1/5
//  @GetMapping("/v1/{id}")
//  public FilmScreeningDto getById(@PathVariable("id") Long id) {
//      return filmScreeningService.get(id);
//  }
//
//  @DeleteMapping("/v1/{id}") 
//  public Boolean delete(@PathVariable("id") Long id) {
//      return filmScreeningService.delete(id);
//  }
//
//  @PostMapping("/v1")
//  public FilmScreeningDto insert(@RequestBody FilmScreeningDto filmScreeningDto) {
//
//      return FilmScreeningService.add(filmScreeningDto);
//  }
//
//  @PutMapping("/v1")
//  public FilmScreeningDto update(@RequestBody FilmScreeningDto filmScreeningDto) {
//      System.out.println("Proiezione" + filmScreeningDto.getId() + "aggiornato con successo!");
//      return filmScreeningDto;
//  }
//
//  @PatchMapping("/v1")
//  public FilmScreeningDto patch(@RequestBody FilmScreeningDto filmScreeningDto) {
//      System.out.println("Proiezione" + filmScreeningDto.getId() + "patched con successo!");
//      return filmScreeningDto;
//  }
//}
