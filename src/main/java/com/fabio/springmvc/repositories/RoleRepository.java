package com.fabio.springmvc.repositories;

import com.fabio.springmvc.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer>{
}
