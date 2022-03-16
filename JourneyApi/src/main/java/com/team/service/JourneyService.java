//package com.team.service;
//
//import com.team.entity.Journey;
//
//public interface JourneyService {
//	public Journey getJourneyById(int id);
//	public boolean saveJourney(Journey journey);
//	
//}

package com.team.service;

import com.team.entity.Journey;

public interface JourneyService {
	public Journey getJourneyById(int id);
	public boolean saveJourney(Journey journey);
	public boolean startJourney(int userId, int startStationId);
	public Journey updateJourney(int userId, int endStationId);
}
