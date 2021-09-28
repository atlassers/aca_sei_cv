package it.euris.academy.cinema.service;

import java.util.List;
import it.euris.academy.cinema.data.dto.CustomerDto;

public interface CustomerService {
  public List<CustomerDto> getAll();

  public CustomerDto get(Long id);

  public CustomerDto add(CustomerDto studentDto);

  public CustomerDto update(CustomerDto studentDto);

  public Boolean delete(Long id);
}
