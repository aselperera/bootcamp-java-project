package com.team.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User getUserById(int id) {
		return restTemplate.getForObject("http://localhost:8001/users/"+id, User.class);
	}

	@Override
	public boolean saveUser(User user) {
		Boolean newUser = restTemplate.postForObject("http://localhost:8001/users", user, Boolean.class);
		if(newUser != null)
			return true;
		return false;
	}
	
	@Override
	public boolean updateUser(User user) {
//		Boolean updatedUser = restTemplate.exchange("http://localhost:8001/users", HttpMethod.PUT, user, User.class);
//		if(updatedUser != null)
//			return true;
//		return false;
		System.out.println("Under Development");
	}
}
