package com.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.entity.Bill;
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
		modelAndView.addObject("station", new Station());
		modelAndView.setViewName("swipeIn");
		return modelAndView;
	}
	
	@RequestMapping("/swipeOutForm")
	public ModelAndView getSwipeOut(@ModelAttribute("station") Station station) {
		ModelAndView modelAndView = new ModelAndView();
		Station stat = stationService.getStationById(station.getSequenceNumber());
		String message = "You have successfully swiped in at " + stat.getStationName();
		List<Station> allStations = stationService.getAllStations();
		modelAndView.addObject("message", message);
		modelAndView.addObject("stations", allStations);
		modelAndView.setViewName("swipeOut");
		return modelAndView;
	}
	
	@RequestMapping("/swipeOut")
	public ModelAndView swipeOutController(@RequestParam("userId") int userId, @RequestParam("station") int stationId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Bill bill = journeyService.swipeOut(userId, stationId);
		
		if(bill != null) {
			modelAndView.addObject("bill", bill);
			modelAndView.setViewName("bill");
		} else {
			modelAndView.addObject("message", "Swipe out failed.");
			modelAndView.setViewName("output");
		}
		
		return modelAndView;
	}

}
