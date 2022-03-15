package com.team.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.entity.Journey;
import com.team.entity.User;
import com.team.persistence.JourneyDao;

@Service
public class JourneyServiceImpl implements JourneyService {
	@Autowired
	JourneyDao journeyDao;
	
	
	/*
	@Override
	public Journey getJourneyById(int userId) {
		User user = restTemplate.getForObject("http://localhost:8001/users/"+userId, User.class);	
		Journey journey = new
	*/

	@Override
	public boolean saveJourney(Journey journey) {
		Journey savedJourney = journeyDao.save(journey);
		if(savedJourney != null) {
			return true;
		}
		return false;
	}
	
	public LocalDateTime getCurrentTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		return currentTime;
	}

	@Override
	public Journey getJourneyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
