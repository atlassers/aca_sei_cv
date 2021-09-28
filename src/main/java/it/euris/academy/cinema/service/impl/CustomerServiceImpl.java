package it.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.cinema.data.dto.CustomerDto;
import it.euris.academy.cinema.data.model.Customer;
import it.euris.academy.cinema.exception.IdMustBeNullException;
import it.euris.academy.cinema.exception.IdMustNotBeNull;
import it.euris.academy.cinema.repository.CustomerRepository;
import it.euris.academy.cinema.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerDto> getAll() {
    return customerRepository.findAll().stream()
        .map(curCustomer -> curCustomer.toDto()).collect(Collectors.toList());
}

  @Override
  public CustomerDto get(Long id) {
    Optional<Customer> customer = customerRepository.findById(id);
    if(customer.isPresent()) {
        return customer.get().toDto();
    }
    return null;
  }

  @Override
  public CustomerDto add(CustomerDto customerDto) {
    if(customerDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return customerRepository.save(customerDto.toModel()).toDto();
  }

  @Override
  public CustomerDto update(CustomerDto customerDto) {
    if(customerDto.getId() == null) {
      throw new IdMustNotBeNull();
    }
    return customerRepository.save(customerDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    customerRepository.deleteById(id);
    Optional<Customer> deletedCustomer = customerRepository.findById(id);
    if(deletedCustomer.isEmpty()) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
}
