package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.repositories.UserRepository;
import com.fabio.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("springdatajpa")
public class UserServiceRepoImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceRepoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<?> listAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
