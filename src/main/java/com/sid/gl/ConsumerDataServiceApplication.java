package com.sid.gl;

import com.sid.gl.service.CustomerSoapService;
import com.sid.gl.service.CustomerWS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ConsumerDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDataServiceApplication.class, args);
	}

	@Bean
	CustomerSoapService customerSoapService(){
		return new CustomerWS().getCustomerSoapServicePort();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
