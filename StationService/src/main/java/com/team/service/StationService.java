package com.team.service;

import java.util.List;

import com.team.entity.Station;

public interface StationService {
	
	public Station getStationById(int id);
	public Station saveStation(Station station);
	public List<Station> getAllStations();

}
