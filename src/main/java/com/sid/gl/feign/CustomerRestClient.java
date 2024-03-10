package com.sid.gl.feign;

import com.sid.gl.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "${uri-costumer-service}",value = "customer-rest-client")
public interface CustomerRestClient  {
    @GetMapping("/customers")
     List<Customer> getCustomers();
    @GetMapping("/customers/{id}")
     Customer getCustomerById(@PathVariable(name="id") Long id);
}
