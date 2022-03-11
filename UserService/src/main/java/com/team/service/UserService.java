package com.team.service;

import com.team.entity.User;

public interface UserService {
	public User getUserById(int id);
	public boolean saveUser(User user);
	User updatePassword(String password, int id);
}
