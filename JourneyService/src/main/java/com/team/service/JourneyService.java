package com.team.service;

import com.team.entity.Journey;
import com.team.entity.Journeys;

public interface JourneyService {
	public Journeys getJourneyById(int id);
	public boolean saveJourney(Journey journey);
}
