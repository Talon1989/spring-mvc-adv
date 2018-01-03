package com.fabio.springmvc.converters;

import com.fabio.springmvc.commands.CustomerForm;
import com.fabio.springmvc.domain.Address;
import com.fabio.springmvc.domain.Customer;
import com.fabio.springmvc.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerFormToCustomer implements Converter<CustomerForm, Customer> {

    @Override
    public Customer convert(CustomerForm customerForm) {
        Customer customer = new Customer();
        customer.setUser(new User());
        customer.setBillingAddress(new Address());
        customer.setShippingAddress(new Address());
        customer.getUser().setId(customerForm.getUserId());
        customer.getUser().setVersion(customerForm.getUserVersion());
        customer.setId(customerForm.getCustomerId());
        customer.setVersion(customerForm.getCustomerVersion());
        customer.getUser().setUsername(customerForm.getUserName());
        customer.getUser().setPassword(customerForm.getPasswordText());
        customer.setFirstName(customerForm.getFirstName());
        customer.setLastName(customerForm.getLastName());
        customer.setEmail(customerForm.getEmail());
        customer.setPhoneNumber(customerForm.getPhoneNumber());
        // added for billingAddress
        customer.getBillingAddress().setAddressLine1(customerForm.getAddressAddressLine1());
        customer.getBillingAddress().setAddressLine2(customerForm.getAddressAddressLine2());
        customer.getBillingAddress().setCity(customerForm.getAddressCity());
        customer.getBillingAddress().setState(customerForm.getAddressState());
        customer.getBillingAddress().setZipCode(customerForm.getAddressZipCode());
        return customer;
    }
}
