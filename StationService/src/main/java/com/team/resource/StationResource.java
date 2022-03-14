package com.team.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.entity.Station;
import com.team.entity.StationList;
import com.team.service.StationService;

@RestController
public class StationResource {
	
	@Autowired
	private StationService stationService;
	
	@GetMapping(path="/stations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Station getStationByIdResource(@PathVariable("id") int id) {
		return stationService.getStationById(id);
	}
	
	@GetMapping(path="/stations/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public StationList getAllStationsResource() {
		return stationService.getAllStations();
	}

	@PostMapping(path="/stations", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Station saveStationResource(@RequestBody Station station) {
		return stationService.saveStation(station);
	}
}
