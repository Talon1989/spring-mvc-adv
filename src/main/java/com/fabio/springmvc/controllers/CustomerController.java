package com.fabio.springmvc.controllers;

import com.fabio.springmvc.commands.CustomerForm;
import com.fabio.springmvc.domain.Customer;
import com.fabio.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new CustomerForm());
        return "customer/customerform";
    }
    @PostMapping
    public String saveOrUpdateCustomer(CustomerForm customerForm){
        Customer savedCustomer = customerService.saveOrUpdateCustomerForm(customerForm);
        return "redirect:/customer/"+savedCustomer.getId();
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Customer customer = customerService.getById(id);
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
        model.addAttribute("customer", customerForm);
        return "customer/customerform";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
