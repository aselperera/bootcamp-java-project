package com.team.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.entity.Station;
import com.team.persistence.StationDao;

@SpringBootTest
class StationApiApplicationTests {
	
	@Autowired
	private StationDao stationDao;
	
	

	@Test
	void contextLoads() {
		Station s1= new Station(44, "Glasgow Central");
		
		assertThat(stationDao.getById(44).getStationName()).isEqualTo("Glasgow Central");
	}

}
