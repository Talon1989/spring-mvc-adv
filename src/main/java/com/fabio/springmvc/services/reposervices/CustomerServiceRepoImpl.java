package com.fabio.springmvc.services.reposervices;

import com.fabio.springmvc.commands.CustomerForm;
import com.fabio.springmvc.converters.CustomerFormToCustomer;
import com.fabio.springmvc.domain.Customer;
import com.fabio.springmvc.repositories.CustomerRepository;
import com.fabio.springmvc.repositories.UserRepository;
import com.fabio.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Profile("springdatajpa")
public class CustomerServiceRepoImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private CustomerFormToCustomer customerFormToCustomer;
    private UserRepository userRepository;

    @Autowired
    public CustomerServiceRepoImpl(CustomerRepository customerRepository, CustomerFormToCustomer customerFormToCustomer, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.customerFormToCustomer = customerFormToCustomer;
        this.userRepository = userRepository;
    }

    @Override
    public List<?> listAll() {
        return (List<Customer>)customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return customerRepository.save(domainObject);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Customer customer = customerRepository.findOne(id);
        userRepository.delete(customer.getUser());
        customerRepository.delete(customer);
    }

    @Override
    public Customer saveOrUpdateCustomerForm(CustomerForm customerForm) {
        Customer newCustomer = customerFormToCustomer.convert(customerForm);
        if(newCustomer.getUser().getId()!=null){
            Customer existingCustomer = getById(newCustomer.getId());
            newCustomer.getUser().setEnabled(existingCustomer.getUser().getEnabled());
        }
        return saveOrUpdate(newCustomer);
    }
}
