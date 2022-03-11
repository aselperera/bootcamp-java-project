package com.team.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.team")
public class MetroSpringbootWebMvcRestclientProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetroSpringbootWebMvcRestclientProjectApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
