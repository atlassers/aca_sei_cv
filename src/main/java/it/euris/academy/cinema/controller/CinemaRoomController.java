package it.euris.academy.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.cinema.data.dto.CinemaRoomDto;
import it.euris.academy.cinema.service.CinemaRoomService;

@RestController
@RequestMapping("/cinema-rooms")
public class CinemaRoomController {
  @Autowired
  CinemaRoomService cinemaRoomService;
  
  @GetMapping("/v1")
  public List<CinemaRoomDto> getAll() {
      return cinemaRoomService.getAll();
  }

  @GetMapping("/v1/{id}")
  public CinemaRoomDto getById(@PathVariable("id") Long id) {
      return cinemaRoomService.get(id);
  }

  @DeleteMapping("/v1/{id}") 
  public Boolean delete(@PathVariable("id") Long id) {
      return cinemaRoomService.delete(id);
  }

  @PostMapping("/v1")
  public CinemaRoomDto insert(@RequestBody CinemaRoomDto cinemaRoomDto) {

      return cinemaRoomService.add(cinemaRoomDto);
  }

  @PutMapping("/v1")
  public CinemaRoomDto update(@RequestBody CinemaRoomDto cinemaRoomDto) {
      System.out.println("Sala" + cinemaRoomDto.getId() + "aggiornata con successo!");
      return cinemaRoomDto;
  }

  @PatchMapping("/v1")
  public CinemaRoomDto patch(@RequestBody CinemaRoomDto cinemaRoomDto) {
      System.out.println("Sala" + cinemaRoomDto.getId() + "patched con successo!");
      return cinemaRoomDto;
  }
}
