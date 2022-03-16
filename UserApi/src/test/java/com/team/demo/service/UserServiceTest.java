package com.team.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.entity.User;
import com.team.persistence.UserDao;
import com.team.service.UserService;
import com.team.service.UserServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	private UserDao userDao;
	@InjectMocks
	private UserService userService = new UserServiceImpl();	

	@Test
	void testGetUserById() {
		
		when(userDao.getById(44)).thenReturn(new User(44, "Abdul", "Rizvi", "ar@ar.com", "password", 29.65));
		
		assertThat(userService.getUserById(44).getFirstName()).isEqualTo("Abdul");
	}

}
