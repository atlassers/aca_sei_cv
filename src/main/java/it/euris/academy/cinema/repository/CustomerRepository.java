package it.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.academy.cinema.data.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
