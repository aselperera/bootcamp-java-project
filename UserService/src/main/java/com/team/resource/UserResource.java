package com.team.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.entity.User;
import com.team.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByIdResource(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveUserResource(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping(path = "/users/{id}/{newPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User updatePasswordResource(@PathVariable("newPassword") String newPassword, @PathVariable("id") int id) {
		return userService.updatePassword(newPassword, id);
	}
	
}
