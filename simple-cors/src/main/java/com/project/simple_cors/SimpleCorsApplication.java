package com.project.simple_cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SimpleCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCorsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer webMvcConfigurer () {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting")
						.allowedOrigins("http://localhost:9000")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}

}
