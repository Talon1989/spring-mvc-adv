package com.fabio.springmvc.services;

import com.fabio.springmvc.commands.CustomerForm;
import com.fabio.springmvc.domain.Customer;

public interface CustomerService extends CrudService<Customer>{
    Customer saveOrUpdateCustomerForm(CustomerForm customerForm);
}
