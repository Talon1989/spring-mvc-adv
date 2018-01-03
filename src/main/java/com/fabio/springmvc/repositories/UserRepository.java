package com.fabio.springmvc.repositories;

import com.fabio.springmvc.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
