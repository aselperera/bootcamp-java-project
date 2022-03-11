package com.team.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.Journey;
import com.team.entity.Journeys;
import com.team.entity.Station;
import com.team.entity.User;
import com.team.persistence.JourneyDao;

@Service
public class JourneyServiceImpl implements JourneyService {
	@Autowired
	JourneyDao journeyDao;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @Override public Journey getJourneyById(int userId) { User user =
	 * restTemplate.getForObject("http://localhost:8001/users/"+userId, User.class);
	 * Journey journey = new
	 */
	@Override
	public Journeys getJourneyById(int userId) {

		Users users=restTemplate.getForObject("http://localhost:8001/users/"+userId, Users.class);
		List<Journey> journeyList=new ArrayList<Journey>();
		
		for (User user:users.getUserList()) {
			Station station=restTemplate.getForObject("htpp://localhost:8002/stations/"+station.getSequenceNumber(), Station.class);
			Journey journey=new Journey(userId, station.getSequenceNumber(), station.getSequenceNumber(), journey.getStartTime(), journey.getEndTime(), journey.getPrice() , journey.isApplyFine());
			journeyList.add(journey);
		}
		
		Journeys journeys=new Journeys(journeyList);
		return journeys;
		
//		return null;

	}

	@Override
	public boolean saveJourney(Journey journey) {
		Journey savedJourney = journeyDao.save(journey);
		if (savedJourney != null) {
			return true;
		}
		return false;
	}

	public LocalDateTime getCurrentTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		return currentTime;
	}

}
