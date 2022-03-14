package com.team.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.team.entity.Journey;
import com.team.persistence.JourneyDao;

@SpringBootApplication(scanBasePackages = "com.team")
@EntityScan(basePackages = "com.team.entity")
@EnableJpaRepositories(basePackages = "com.team.persistence")
public class JourneyServiceApplication {

	@Autowired
	private JourneyDao journeyDao;

	public static void main(String[] args) {
		SpringApplication.run(JourneyServiceApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		// Journey j1= new Journey(101, 202, 203, 2022-03-14T15:29:01.101040,
		// 2022-03-14T15:29:01.101040, 12, false);
		Journey j1 = new Journey(101, 202, 203);

		journeyDao.save(j1);

	}
}