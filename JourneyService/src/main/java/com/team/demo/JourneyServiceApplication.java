package com.team.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.team")
@EntityScan(basePackages = "com.team.entity")
@EnableJpaRepositories(basePackages = "com.team.persistence")
public class JourneyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JourneyServiceApplication.class, args);
	}

}
