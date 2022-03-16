package com.team.model.service;

import com.team.entity.Journey;

public interface JourneyService {

	Journey getJourneyById(int userId);
	boolean swipeOut(int userId, int stationId);
	boolean startJourney(int userId, int stationId);

}
