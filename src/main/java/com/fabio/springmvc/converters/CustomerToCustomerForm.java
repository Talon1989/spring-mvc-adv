package com.fabio.springmvc.converters;

import com.fabio.springmvc.commands.CustomerForm;
import com.fabio.springmvc.domain.Customer;
import groovy.transform.ConditionalInterrupt;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerForm implements Converter<Customer, CustomerForm>{

    @Override
    public CustomerForm convert(Customer customer) {
        CustomerForm customerForm = new CustomerForm();

        customerForm.setCustomerId(customer.getId());
        customerForm.setCustomerVersion(customer.getVersion());
        customerForm.setEmail(customer.getEmail());
        customerForm.setFirstName(customer.getFirstName());
        customerForm.setLastName(customer.getLastName());
        customerForm.setPhoneNumber(customer.getPhoneNumber());
        if(customer.getUser()!=null) { // added for testing
            customerForm.setUserId(customer.getUser().getId());
            customerForm.setUserName(customer.getUser().getUsername());
            customerForm.setUserVersion(customer.getUser().getVersion());
        }
        if(customer.getBillingAddress()!=null) { // added for testing
            customerForm.setAddressAddressLine1(customer.getBillingAddress().getAddressLine1());
            customerForm.setAddressAddressLine2(customer.getBillingAddress().getAddressLine2());
            customerForm.setAddressCity(customer.getBillingAddress().getCity());
            customerForm.setAddressState(customer.getBillingAddress().getState());
            customerForm.setAddressZipCode(customer.getBillingAddress().getZipCode());
        }

        return customerForm;
    }

}
