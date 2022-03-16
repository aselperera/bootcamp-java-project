package com.team.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.LoginDTO;
import com.team.entity.User;
import com.team.model.service.LoginService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class LoginController {
	
	@Setter
	@Getter
	private User currentUser;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("loginDetails", new LoginDTO());
		modelAndView.setViewName("index");
		
		
		return modelAndView;
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheckController(@ModelAttribute("loginDetails") LoginDTO loginDetails, HttpSession session) {
		ModelAndView modelAndView=new ModelAndView();
		User currentUser = loginService.loginCheck(loginDetails);
		
		if(currentUser != null) {
			modelAndView.addObject("user", currentUser);
			session.setAttribute("user", currentUser);
			String message =" Login successful! Hello, " + currentUser.getFirstName();
			modelAndView.addObject("message", message);
			modelAndView.setViewName("output");
			this.currentUser=currentUser;

		}
		else {
			String message =" Login Failed!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("output");
		}
		
		return modelAndView;
		
	}
}
