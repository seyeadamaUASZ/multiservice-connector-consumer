package com.sid.gl.controller;

import com.sid.gl.model.Customer;
import com.sid.gl.service.CustomerResponse;
import com.sid.gl.service.CustomerSoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerSoapController {
    @Autowired
    private CustomerSoapService customerSoapService;

    @GetMapping("/customers/soap")
    public List<Customer> listCustomer(){
        return customerSoapService.customerList()
                .stream()
                .map(this::toCustomer)
                .collect(Collectors.toList());
    }

    @GetMapping("/customers/soap/{id}")
    public  Customer getCustomerById(@PathVariable Long id){
        CustomerResponse response = customerSoapService.getCustomer(id);
        return toCustomer(response);
    }

    private Customer toCustomer(CustomerResponse customerResponse){
        Customer customer =new Customer();
        customer.setId(customerResponse.getId());
        customer.setEmail(customerResponse.getEmail());
        customer.setName(customerResponse.getName());
        return customer;
    }

}
