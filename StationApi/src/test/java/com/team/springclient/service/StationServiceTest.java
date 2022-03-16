package com.team.springclient.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.entity.Station;
import com.team.persistence.StationDao;
import com.team.service.StationService;
import com.team.service.StationServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StationServiceTest {
	
	@Mock
	private StationDao stationDao;
	@InjectMocks
	private StationService stationService=new StationServiceImpl();
	
	@Test
	void testGetStationById() {
		
		when(stationDao.getById(1)).thenReturn(new Station(1,"Station1"));
		
		assertThat(stationService.getStationById(1).getStationName()).isEqualTo("Station1");
		
		
	}

}
