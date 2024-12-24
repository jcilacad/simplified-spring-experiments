package com.projects.spring_cloud_circuit_breaker_reading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final ReactiveCircuitBreaker reactiveCircuitBreaker;
    private final WebClient webClient;

    public BookService(ReactiveCircuitBreakerFactory reactiveCircuitBreaker) {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
        this.reactiveCircuitBreaker = reactiveCircuitBreaker.create("recommend");
    }

    public Mono<String> readingList() {
        return reactiveCircuitBreaker.run(webClient.get().uri("/recommend").retrieve().bodyToMono(String.class), throwable -> {
            logger.warn("Error making requests to book service");
            return Mono.just("Backup book");
        });
    }
}
