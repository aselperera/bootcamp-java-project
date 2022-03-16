package com.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.Station;
import com.team.model.service.JourneyService;
import com.team.model.service.StationService;

@Controller
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@Autowired
	private JourneyService journeyService;
	
	@RequestMapping("/swipeInForm")
	public ModelAndView getSwipeIn() {
		ModelAndView modelAndView = new ModelAndView();
		List<Station> allStations = stationService.getAllStations();
		modelAndView.addObject("stations", allStations);
		modelAndView.setViewName("swipeIn");
		return modelAndView;
	}
	
	@RequestMapping("/swipeOutForm")
	public ModelAndView getSwipeOut() {
		ModelAndView modelAndView = new ModelAndView();
		List<Station> allStations = stationService.getAllStations();
		modelAndView.addObject("stations", allStations);
		modelAndView.setViewName("swipeOut");
		return modelAndView;
	}
	
	@RequestMapping("/swipeOut")
	public ModelAndView swipeOutController(@RequestParam("userId") int userId, @RequestParam("station") int stationId) {
		ModelAndView modelAndView = new ModelAndView();
		
		String message = null;
		if(journeyService.swipeOut(userId, stationId)) {
			message = "Swiped out successfully!";
		} else {
			message = "Swipe out failed.";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("output");
		return modelAndView;
	}

}
