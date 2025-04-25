package com.example.EventBookingSyste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.EventBookingSyste.model")  // Ensure it's scanning your model package
@EnableJpaRepositories(basePackages = "com.example.EventBookingSyste.repository")  // Enable JPA repositories
public class EventBookingSysteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventBookingSysteApplication.class, args);
	}

}
