package com.projects.cachingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CachingDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingDataApplication.class, args);
	}

}
