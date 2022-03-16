package com.team.demo.service;

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

import com.team.entity.Journey;
import com.team.persistence.JourneyDao;
import com.team.service.JourneyService;
import com.team.service.JourneyServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JourneyServiceTest {
	
	@Mock
	private JourneyDao journeyDao;
	@InjectMocks
	private JourneyService journeyService=new JourneyServiceImpl();
	
	@Test
	void testGetJourneyById() {
		
		when(journeyDao.getById(101)).thenReturn(new Journey(101, 202, 203, LocalDateTime.now(), LocalDateTime.now(), 18.0, false));
		
		assertThat(journeyService.getJourneyById(101).getStartStationId()).isEqualTo(202);
	}

}
