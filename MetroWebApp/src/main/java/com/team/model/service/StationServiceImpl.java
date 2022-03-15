package com.team.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.team.entity.Station;
import com.team.entity.StationList;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Station getStationById(int id) {
		return restTemplate.getForObject("http://localhost:8002/stations/"+id, Station.class);
	}

	@Override
	public List<Station> getAllStations() {
		return restTemplate.getForObject("http://localhost:8002/stations/all", StationList.class).getStationList();
	}
}
