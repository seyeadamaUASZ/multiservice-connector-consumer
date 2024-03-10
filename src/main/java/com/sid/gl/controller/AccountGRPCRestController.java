package com.sid.gl.controller;

import com.sid.gl.model.Customer;
import com.sid.gl.service.GprcService;
import com.sid.gl.stub.CustomerServiceOuterClass;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class AccountGRPCRestController {
   private GprcService gprcService;

    @GetMapping("/customer/grpc")
    public List<Customer> getCustomerGRPC(){
      return gprcService.getCustomerGRPC();
    }

    @GetMapping("/customer/grpc/{id}")
    public Customer getCustomerById(@PathVariable Long id){
       return gprcService.getCustomerById(id);
    }

    @PostMapping("/customer/grpc")
    public Customer saveCustomer(@RequestBody CustomerServiceOuterClass.SaveCustomerRequest request){
       return gprcService.saveCustomer(request);
    }


}
