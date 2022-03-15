package com.team.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.Journey;
import com.team.entity.Station;
import com.team.entity.User;

import com.team.persistence.JourneyDao;

@Service
public class JourneyServiceImpl implements JourneyService {
	@Autowired
	JourneyDao journeyDao;

	@Override
	public Journey getJourneyById(int userId) {

		return journeyDao.getById(userId);

	}

	@Override
	public boolean saveJourney(Journey journey) {
		Journey savedJourney = journeyDao.save(journey);
		if (savedJourney != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean startJourney(int userId, int startStationId) {
		int rows = journeyDao.startJourney(userId, startStationId, false);//hardcoded false for applyFine
		
		if (rows >0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJourney(int userId, int endStationId, LocalDateTime endTime, double price) {
		int rows = journeyDao.updateJourney(userId, endStationId, endTime, price);
		if (rows >0) {
			return true;
		}
		return false;
	}

//	public LocalDateTime getCurrentTime() {
//		LocalDateTime currentTime = LocalDateTime.now();
//		return currentTime;
//	}
	
	

}
