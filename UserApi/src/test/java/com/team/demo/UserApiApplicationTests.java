package com.team.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.team.persistence.UserDao;

@SpringBootTest
class UserApiApplicationTests {

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {

		//User u1 = new User(105, "Abdul", "Rizvi", "ar@ar.com", "password", 29.65);
		//userDao.save(u1); //saves into the database
		assertThat(userDao.getById(1).getFirstName()).isEqualTo("Asel");//only works if data is in database

	}
}
