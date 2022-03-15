package com.team.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.team.entity.User;
import com.team.persistence.UserDao;

import com.team.entity.User;
import com.team.persistence.UserDao;

@EntityScan(basePackages = "com.team.entity")
@EnableJpaRepositories(basePackages = "com.team.persistence")
@SpringBootApplication(scanBasePackages = "com.team")
public class UserServiceApplication implements CommandLineRunner {
	@Autowired
	UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1, "Lili", "Vincze", "lili.v@gmail.com", "password", 950.0);
		userDao.save(u1);
	}

}
