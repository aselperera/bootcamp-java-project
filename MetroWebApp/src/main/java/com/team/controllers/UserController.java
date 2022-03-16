
package com.team.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.User;
import com.team.model.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginController loginController;
	
	@RequestMapping("/signup")
	public ModelAndView newUserPageController() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("signUpUser");
		
		return modelAndView;
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView newUserController(@ModelAttribute("user") User user) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message = null;
		if(userService.saveUser(user))
			message="User Added Succesfully";
		else
			message="User Addition Failed";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("output");
		
		return modelAndView;
	}
	
	@RequestMapping("/topUpBalance")
	public ModelAndView getTopUp(@ModelAttribute("balance") double balance) {
		ModelAndView modelAndView = new ModelAndView();

		if(userService.topUpBalance(loginController.getCurrentUser().getId(), balance)) {
			modelAndView.addObject("balance");
			String message = "Top up Successful!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("output");
		}
		else {
				String message = "Top Up Failed!";
				modelAndView.addObject("message", message);
				modelAndView.setViewName("index");
			}
		return modelAndView;
	}
	
//	@RequestMapping("/updateUser")
//	public ModelAndView updateUserController(@ModelAttribute("user") User user) {
//		ModelAndView modelAndView=new ModelAndView();
//		
//		User currentUser = loginController.getCurrentUser();
//		String message = null;
//		if(userService.updateUser(currentUser))
//			message="User updated Succesfully";
//		else
//			message="User update Failed";
//		
//		modelAndView.addObject("message", message);
//		modelAndView.setViewName("output");
//		
//		return modelAndView;
//	}
}