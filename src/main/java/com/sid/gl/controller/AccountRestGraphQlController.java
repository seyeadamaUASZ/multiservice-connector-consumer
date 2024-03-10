package com.sid.gl.controller;

import com.sid.gl.model.Customer;
import com.sid.gl.model.CustomerRequest;
import com.sid.gl.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestGraphQlController {
    private AccountService accountService;

    @GetMapping("/customers/gql/{id}")
    public Mono<Customer> getCustomerById(@PathVariable Long id) {
        return accountService.getCustomerByIdFromGaphQl(id);
    }

    @GetMapping("/customers/gql")
    public Mono<List<Customer>> getCustomers() {
        return accountService.getCustomers();
    }

    @PostMapping("/customers/gql/save")
    public Mono<Customer> saveCustomer(@RequestBody CustomerRequest customerRequest) {
        return accountService.saveCustomer(customerRequest);
    }
}
