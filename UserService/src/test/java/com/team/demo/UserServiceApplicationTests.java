package com.team.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.entity.User;
import com.team.persistence.UserDao;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		
		User u1=new User(10, "Abdul", "Rizvi", "ar@ar.com", "password", 29.65);
		
		assertThat(userDao.getById(10).getFirstName()).isEqualTo("Abdul");
		
		
	}

}
