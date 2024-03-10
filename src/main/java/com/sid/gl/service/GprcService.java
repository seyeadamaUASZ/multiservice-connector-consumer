package com.sid.gl.service;

import com.sid.gl.model.Customer;
import com.sid.gl.stub.CustomerServiceGrpc;
import com.sid.gl.stub.CustomerServiceOuterClass;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GprcService {
    @GrpcClient("customerService")
    private CustomerServiceGrpc.CustomerServiceBlockingStub serviceBlockingStub;

    public List<Customer> getCustomerGRPC(){
        CustomerServiceOuterClass.GetAllCustomersRequest request=
                CustomerServiceOuterClass.GetAllCustomersRequest.newBuilder().build();

        CustomerServiceOuterClass.GetCustomersResponse response=
                serviceBlockingStub.getAllCustomer(request);
        List<CustomerServiceOuterClass.Customer> customers=
                response.getCustomersList();
        return customers.stream()
                .map(this::toCustomer)
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(Long id){
        CustomerServiceOuterClass.GetCustomerByIdRequest request=
                CustomerServiceOuterClass.GetCustomerByIdRequest.newBuilder()
                        .setCustomerId(id)
                        .build();
        CustomerServiceOuterClass.GetCustomerByIdResponse customerByIdResponse =
                serviceBlockingStub.getCustomerById(request);
        return toCustomer(customerByIdResponse.getCustomer());
    }

    public Customer saveCustomer(CustomerServiceOuterClass.SaveCustomerRequest request){
        CustomerServiceOuterClass.SaveCustomerResponse response=
                serviceBlockingStub.saveCustomer(request);
        CustomerServiceOuterClass.Customer customerGrpc = response.getCustomer();
        return toCustomer(customerGrpc);
    }

    private Customer toCustomer(CustomerServiceOuterClass.Customer customerGRPC){
        Customer customer = new Customer();
        customer.setName(customerGRPC.getName());
        customer.setEmail(customerGRPC.getEmail());
        customer.setId(customerGRPC.getId());
        return customer;

    }


}
