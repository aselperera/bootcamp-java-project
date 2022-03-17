package com.team.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.Bill;
import com.team.entity.Station;
import com.team.entity.User;
import com.team.model.service.JourneyService;
import com.team.model.service.LoginService;
import com.team.model.service.StationService;
import com.team.model.service.UserService;

@Controller
public class StationController {
	
	@Autowired
	private LoginController loginController;
	
	@Autowired
	private StationService stationService;
	
	@Autowired
	private JourneyService journeyService;
	
	@Autowired
	private UserService userService; // To get user again after updating balance
	
	@RequestMapping("/swipeInForm")
	public ModelAndView getSwipeIn() {
		ModelAndView modelAndView = new ModelAndView();
		List<Station> allStations = stationService.getAllStations();
		modelAndView.addObject("stations", allStations);
		modelAndView.addObject("station", new Station());
		modelAndView.setViewName("swipeIn");
		return modelAndView;
	}
	
	@RequestMapping("/swipeOutForm")
	public ModelAndView getSwipeOut(@ModelAttribute("station") Station station) {
		ModelAndView modelAndView = new ModelAndView();
		
		// Creating Journey object
		User user = loginController.getCurrentUser();
		Station stat = stationService.getStationById(station.getSequenceNumber());
		
		if(journeyService.startJourney(user.getId(), stat.getSequenceNumber())) {
			String message = "You have successfully swiped in at " + stat.getStationName();
			List<Station> allStations = stationService.getAllStations();
			modelAndView.addObject("message", message);
			modelAndView.addObject("stations", allStations);
			modelAndView.setViewName("swipeOut");
		} else {
			String message = "Swipe in failed.";
			modelAndView.addObject("message,", message);
			modelAndView.setViewName("message");
		}
	
		return modelAndView;
	}
	
	@RequestMapping("/swipeOut")
	public ModelAndView swipeOutController(@RequestParam("station") int stationId) {
		ModelAndView modelAndView = new ModelAndView();
		
		// Get user
		User user = loginController.getCurrentUser();
		
		Bill bill = journeyService.swipeOut(user.getId(), stationId);
		
		// Get user again - with updated balance
		User updatedUser = userService.getUserById(user.getId());
		
		if(bill != null) {
			modelAndView.addObject("user", updatedUser); // To get new balance
			modelAndView.addObject("bill", bill);
			modelAndView.setViewName("bill");
		} else {
			modelAndView.addObject("message", "Swipe out failed.");
			modelAndView.setViewName("output");
		}
		
		return modelAndView;
	}

}
