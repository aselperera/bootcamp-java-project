package com.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.entity.User;
import com.team.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int id) {
		return userDao.getById(id);
	}

	@Override
	public boolean saveUser(User user) {
		User savedUser = userDao.save(user);
		if(savedUser != null) {
			return true;
		}
		return false;
	}

	@Override
	public User updatePassword(String password, int id) {
		userDao.updatePassword(password, id);
		return userDao.getById(id);
	}

}
