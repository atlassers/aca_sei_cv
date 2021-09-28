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
import it.euris.academy.cinema.data.dto.CustomerDto;
import it.euris.academy.cinema.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired
  CustomerService customerService;
  
  @GetMapping("/v1")
  public List<CustomerDto> getAll() {
      return customerService.getAll();
  }

  @GetMapping("/v1/{id}")
  public CustomerDto getById(@PathVariable("id") Long id) {
      return customerService.get(id);
  }


  @DeleteMapping("/v1/{id}") 
  public Boolean delete(@PathVariable("id") Long id) {
      return customerService.delete(id);
  }

  @PostMapping("/v1")
  public CustomerDto insert(@RequestBody CustomerDto customerDto) {

      return customerService.add(customerDto);
  }

  @PutMapping("/v1")
  public CustomerDto update(@RequestBody CustomerDto customerDto) {
      System.out.println("Utente" + customerDto.getId() + "aggiornato con successo!");
      return customerDto;
  }

  @PatchMapping("/v1")
  public CustomerDto patch(@RequestBody CustomerDto customerDto) {
      System.out.println("Utente" + customerDto.getId() + "patched con successo!");
      return customerDto;
  }
}
