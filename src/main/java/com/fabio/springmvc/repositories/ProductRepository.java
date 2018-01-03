package com.fabio.springmvc.repositories;

import com.fabio.springmvc.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
