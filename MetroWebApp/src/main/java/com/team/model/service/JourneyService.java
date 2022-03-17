package com.team.model.service;

import com.team.entity.Bill;
import com.team.entity.Journey;

public interface JourneyService {

	Journey getJourneyById(int userId);
	Bill swipeOut(int userId, int stationId);
	boolean startJourney(int userId, int stationId);
	//boolean hasUnfinishedJourney(int userId);
}
