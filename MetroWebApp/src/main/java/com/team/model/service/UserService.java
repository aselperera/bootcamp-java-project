package com.team.model.service;

import com.team.entity.User;

public interface UserService {
	public User getUserById(int id);
	public boolean saveUser(User user);
//	public boolean updateUser(User user);
	public boolean topUpBalance(int userId, double topUpAmount);
	
}
