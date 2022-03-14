package com.team.model.service;

import java.util.List;

import com.team.entity.Station;
import com.team.entity.StationList;

public interface StationService {

	public Station getStationById(int id);
	public List<Station> getAllStations();
}
