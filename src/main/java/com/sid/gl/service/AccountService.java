package com.sid.gl.service;

import com.sid.gl.feign.CustomerRestClient;
import com.sid.gl.model.Customer;
import com.sid.gl.model.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountService {
    @Value("${uri-costumer-service}")
    private String baseUrl;
    @Value(("${uri-costumer-graphql}"))
    private String uriGraphql;
    private String URI = "/customers";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerRestClient customerRestClient;

    public List<Customer> customerList() {
        Customer[] customers = restTemplate.getForObject(baseUrl + URI, Customer[].class);
        return List.of(customers);
    }

    public Flux<Customer> listCustomer() {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        Flux<Customer> customerFlux = webClient.get().
                uri(URI).
                retrieve().bodyToFlux(Customer.class);
        return customerFlux;
    }

    public Customer getCustomerById(Long id) {
        return restTemplate.getForObject(baseUrl + URI + "/" + id, Customer.class);
    }

    public Mono<Customer> getCustomerByIdV2(@PathVariable Long id) {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        Mono<Customer> customer = webClient.get().
                uri(URI + "/{id}", id).
                retrieve().bodyToMono(Customer.class);
        return customer;
    }

    public List<Customer> listCustomerV3() {
        return customerRestClient.getCustomers();
    }

    public Customer getCustomerV3(Long id) {
        return customerRestClient.getCustomerById(id);
    }

    public Mono<Customer> getCustomerByIdFromGaphQl(Long id) {
        HttpGraphQlClient httpGraphQlClient = HttpGraphQlClient.builder()
                .url(uriGraphql)
                .build();
        var httpRequestDocument = """
                query($id:Int){
                customerById(id:$id){
                 id,name,email
                }
                }
                               
                """;
        Mono<Customer> customerMono = httpGraphQlClient.document(httpRequestDocument).variable("id", id).
                retrieve("customerById").toEntity(Customer.class);
        return customerMono;
    }

    public Mono<List<Customer>> getCustomers() {
        HttpGraphQlClient httpGraphQlClient = HttpGraphQlClient.builder()
                .url(uriGraphql)
                .build();
        var httpRequestDocument = """
                 query {
                 allCustomers{
                  name,email,id
                 }
                }
                 """;
        Mono<List<Customer>> customerlist = httpGraphQlClient.document(httpRequestDocument)
                .retrieve("allCustomers")
                .toEntityList(Customer.class);
        return customerlist;
    }

    public Mono<Customer> saveCustomer(CustomerRequest customerRequest) {
        HttpGraphQlClient httpGraphQlClient = HttpGraphQlClient.builder()
                .url(uriGraphql)
                .build();
        var httpRequestDocument = """
                mutation($name:String,$email:String) {
                  saveCustomer(customer:{
                    name:$name,
                    email:$email
                  }){
                    id,name,email
                  }
                }
                """;
        Mono<Customer> customerMono = httpGraphQlClient.document(httpRequestDocument)
                .variable("name", customerRequest.getName())
                .variable("email", customerRequest.getEmail())
                .retrieve("saveCustomer")
                .toEntity(Customer.class);
        return customerMono;

    }
}
