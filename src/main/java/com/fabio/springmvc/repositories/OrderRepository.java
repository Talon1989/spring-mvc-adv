package com.fabio.springmvc.repositories;

import com.fabio.springmvc.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
