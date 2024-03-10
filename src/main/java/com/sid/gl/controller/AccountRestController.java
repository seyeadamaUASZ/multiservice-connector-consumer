package com.sid.gl.controller;


import com.sid.gl.model.Customer;
import com.sid.gl.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;

    @GetMapping("/customers")
    public List<Customer> customerList() {
        return accountService.customerList();
    }

    @GetMapping("/customers/v2")
    public Flux<Customer> listCustomer() {
        return accountService.listCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return accountService.getCustomerById(id);
    }

    @GetMapping("/customers/v2/{id}")
    public Mono<Customer> getCustomerByIdV2(@PathVariable Long id) {
        return accountService.getCustomerByIdV2(id);
    }

    @GetMapping("/customers/v3")
    public List<Customer> listCustomerV3() {
        return accountService.listCustomerV3();
    }

    @GetMapping("/customers/v3/{id}")
    public Customer getCustomerV3(@PathVariable Long id) {
        return accountService.getCustomerV3(id);
    }
}
