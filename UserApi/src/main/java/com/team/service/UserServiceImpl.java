package com.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.entity.LoginDTO;
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
	public double updateBalance(double topUpAmount, int id) {
		double balance = userDao.getById(id).getBalance() + topUpAmount;
		userDao.updateBalance(balance, id);
		return userDao.getById(id).getBalance();
	}

	@Override
	public User login(LoginDTO loginDetails) {
		User usr = userDao.findUserByEmailAndPassword(loginDetails.getEmail(), loginDetails.getPassword());
		if(usr!=null)
			return usr;
		return null;
	}
	
	@Override
	public User updateUser(User user) {
		userDao.updateUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());
		User updatedUser = getUserById(user.getId());
		return updatedUser;
	}
}
