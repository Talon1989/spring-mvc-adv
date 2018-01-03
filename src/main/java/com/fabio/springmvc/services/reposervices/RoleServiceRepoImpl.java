package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.domain.security.Role;
import com.fabio.springmvc.repositories.RoleRepository;
import com.fabio.springmvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("springdatajpa")
public class RoleServiceRepoImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceRepoImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<?> listAll() {
        return (List<Role>)roleRepository.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.delete(id);
    }
}
