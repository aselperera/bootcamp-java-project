package com.team.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.LoginDTO;
import com.team.entity.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User loginCheck(LoginDTO loginDetails) {
		return restTemplate.postForObject("http://localhost:8001/users/login", loginDetails, User.class);
	}
}
