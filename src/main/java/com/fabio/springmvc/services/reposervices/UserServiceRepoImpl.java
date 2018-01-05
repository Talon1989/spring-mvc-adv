package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.domain.User;
import com.fabio.springmvc.repositories.CustomerRepository;
import com.fabio.springmvc.repositories.UserRepository;
import com.fabio.springmvc.services.UserService;
import com.fabio.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Profile("springdatajpa")
public class UserServiceRepoImpl implements UserService{

    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private EncryptionService encryptionService;

    @Autowired
    public UserServiceRepoImpl(UserRepository userRepository, CustomerRepository customerRepository, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.encryptionService = encryptionService;
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
        if(domainObject.getPassword()!=null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        return userRepository.save(domainObject);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = userRepository.findOne(id);
        customerRepository.delete(user.getCustomer());
        userRepository.delete(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
