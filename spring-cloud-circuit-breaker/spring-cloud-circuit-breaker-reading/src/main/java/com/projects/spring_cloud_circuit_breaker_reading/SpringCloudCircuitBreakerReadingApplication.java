package com.projects.spring_cloud_circuit_breaker_reading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class SpringCloudCircuitBreakerReadingApplication {

	private final BookService bookService;

	public SpringCloudCircuitBreakerReadingApplication(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/to-read")
	public Mono<String> readBooks() {
		return bookService.readingList();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudCircuitBreakerReadingApplication.class, args);
	}

}
