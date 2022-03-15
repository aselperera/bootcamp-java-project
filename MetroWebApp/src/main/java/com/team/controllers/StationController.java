package com.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.Station;
import com.team.model.service.StationService;

@Controller
public class StationController {
	
	@Autowired
	private StationService stationService;
	
	@RequestMapping("/swipeInForm")
	public ModelAndView getSwipeIn() {
		ModelAndView modelAndView = new ModelAndView();
		List<Station> allStations = stationService.getAllStations();
		modelAndView.addObject("stations", allStations);
		modelAndView.setViewName("swipeIn");
		return modelAndView;
	}

}
