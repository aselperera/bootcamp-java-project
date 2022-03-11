package com.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.entity.Station;
import com.team.persistence.StationDao;

@Service
public class StationServiceImpl implements StationService {
	
	@Autowired
	private StationDao stationDao;

	@Override
	public Station getStationById(int id) {
		return stationDao.getById(id);
	}

	@Override
	public Station saveStation(Station station) {
		return stationDao.save(station);
	}

}
