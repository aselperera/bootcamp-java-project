package com.team.service;

import com.team.entity.LoginDTO;
import com.team.entity.User;

public interface UserService {
	public User getUserById(int id);
	public boolean saveUser(User user);
	public User updateBalance(double topUpAmount, int id);
	User login(LoginDTO loginDetails);
	User updateUser(User user);
}

