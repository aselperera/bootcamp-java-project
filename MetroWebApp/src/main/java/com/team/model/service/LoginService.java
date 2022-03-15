package com.team.model.service;

import com.team.entity.LoginDTO;
import com.team.entity.User;

public interface LoginService {
	User loginCheck(LoginDTO loginDetails);
}
