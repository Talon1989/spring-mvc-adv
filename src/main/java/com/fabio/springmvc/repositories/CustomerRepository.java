package com.fabio.springmvc.repositories;

import com.fabio.springmvc.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
