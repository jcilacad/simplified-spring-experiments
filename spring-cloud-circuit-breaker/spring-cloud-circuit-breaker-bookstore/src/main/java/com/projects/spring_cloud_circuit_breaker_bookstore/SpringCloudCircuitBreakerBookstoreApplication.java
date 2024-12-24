package com.projects.spring_cloud_circuit_breaker_bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class SpringCloudCircuitBreakerBookstoreApplication {

	@RequestMapping(value = "/recommend")
	public Mono<String> readingList() {
		return Mono.just("The lord of rings, To kill a mockingbird, The great gatsby");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCircuitBreakerBookstoreApplication.class, args);
	}
}
