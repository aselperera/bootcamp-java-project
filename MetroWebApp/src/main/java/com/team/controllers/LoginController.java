package com.team.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.team.entity.Journey;
import com.team.entity.LoginDTO;
import com.team.entity.Station;
import com.team.entity.User;
import com.team.model.service.JourneyService;
import com.team.model.service.LoginService;
import com.team.model.service.StationService;
import com.team.model.service.UserService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class LoginController {
	
	@Setter
	@Getter
	private User currentUser;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StationService stationService;
	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("loginDetails", new LoginDTO());
		modelAndView.setViewName("index");

		return modelAndView;
	}
	
	
	public Journey hasUnfinishedJourney(User user) {
		return userService.hasUnfinishedJourney(user.getId());
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheckController(@ModelAttribute("loginDetails") LoginDTO loginDetails, HttpSession session) {
		
		User currentUser = loginService.loginCheck(loginDetails);
		this.currentUser = currentUser;
		
		if(currentUser != null) {
			Journey journey = hasUnfinishedJourney(currentUser);
			if(journey != null) {
				ModelAndView modelAndView =  new ModelAndView("redirect:/swipeOutForm");
				modelAndView.addObject("user", currentUser);
				session.setAttribute("user", currentUser);
				return modelAndView;
			} else {
				ModelAndView modelAndView =  new ModelAndView("redirect:/swipeInForm");
				modelAndView.addObject("user", currentUser);
				session.setAttribute("user", currentUser);
				return modelAndView;
			}
		}
		else {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("user", currentUser);
			String loginError = "Invalid login details";
			modelAndView.addObject("loginError", loginError);
			modelAndView.setViewName("index");
			return modelAndView;
		}
	}
}
