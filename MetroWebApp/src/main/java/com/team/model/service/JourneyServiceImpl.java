package com.team.model.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.controllers.LoginController;
import com.team.entity.Bill;
import com.team.entity.Journey;
import com.team.entity.Station;
import com.team.entity.User;

@Service
public class JourneyServiceImpl implements JourneyService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StationService stationService;
	
	@Autowired
	private LoginController loginController; // Need to access current user
	
	@Override
	public Journey getJourneyById(int userId) {
		return restTemplate.getForObject("http://localhost:8003/journeys/"+userId, Journey.class);
	}

	@Override
	public Bill swipeOut(int userId, int stationId) {
		
		// Update journey table
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Journey> entity = new HttpEntity<Journey>(header);
		Journey journey = restTemplate.exchange("http://localhost:8003/journeys/update/"+userId+"/"+stationId,
				HttpMethod.PUT,
				entity,
				Journey.class).getBody();
		
		if(journey != null) {
			// Update user balance
			User currentUser = loginController.getCurrentUser();
			User updatedBalanceUser = restTemplate.exchange("http://localhost:8001/users/"+currentUser.getId()+"/"+journey.getPrice()*-1,
					HttpMethod.PUT,
					entity,
					User.class).getBody();
			
			if(updatedBalanceUser != null) {
			
				// Get stations in order to get their names
				Station startStation = stationService.getStationById(journey.getStartStationId());
				Station endStation = stationService.getStationById(journey.getEndStationId());
				
				// Format times
				DateTimeFormatter timeFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
				LocalDateTime startTime = journey.getStartTime();
				LocalDateTime endTime = journey.getEndTime();
				String formattedStartTime = startTime.format(timeFormat);
				String formattedEndTime = endTime.format(timeFormat);
				
				// Determine fare, fine, total fare
				double totalFare = journey.getPrice();
				double fare = totalFare;
				double fine = 0;
				if(journey.isApplyFine()) {
					fine = 10;
					fare -= fine;
				}
				
				Bill bill = new Bill(startStation.getStationName(),
						endStation.getStationName(),
						formattedStartTime,
						formattedEndTime,
						fare,
						fine,
						totalFare);
				return bill;
				
			}
		}
		return null;
	}

	@Override
	public boolean startJourney(int userId, int stationId) {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Journey> entity = new HttpEntity<Journey>(header);
		Journey journey = restTemplate.exchange("http://localhost:8003/journeys/start/"+userId+"/"+stationId,
				HttpMethod.POST,
				entity,
				Journey.class).getBody();
		if(journey != null) {
			return true;
		}
		return false;
	}
	
}
