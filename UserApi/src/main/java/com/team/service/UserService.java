package com.team.service;

import com.team.entity.LoginDTO;
import com.team.entity.User;

public interface UserService {
	public User getUserById(int id);
	public boolean saveUser(User user);
	User updatePassword(String password, int id);
	User login(LoginDTO loginDetails);
	/*
	User updateFirstName(String firstName, int id);
	User updateLastName(String lastName, int id);
	User updateEmail(String email, int id);
	*/
}

