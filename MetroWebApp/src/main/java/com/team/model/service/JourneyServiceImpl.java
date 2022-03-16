package com.team.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.Journey;

@Service
public class JourneyServiceImpl implements JourneyService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Journey getJourneyById(int userId) {
		return restTemplate.getForObject("http://localhost:8003/journeys/"+userId, Journey.class);
	}

	@Override
	public boolean swipeOut(int userId, int stationId) {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Journey> entity = new HttpEntity<Journey>(header);
		Journey journey = restTemplate.exchange("http://localhost:8003/journeys/update/"+userId+"/"+stationId,
				HttpMethod.PUT,
				entity,
				Journey.class).getBody();
		if(journey != null) {
			return true;
		}
		return false;
	}
	
}
