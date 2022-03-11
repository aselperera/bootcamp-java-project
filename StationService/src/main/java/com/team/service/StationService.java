package com.team.service;

import com.team.entity.Station;

public interface StationService {
	
	public Station getStationById(int id);
	public Station saveStation(Station station);

}
