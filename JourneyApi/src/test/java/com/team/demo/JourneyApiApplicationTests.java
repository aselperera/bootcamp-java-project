package com.team.demo;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.team.entity.Journey;
import com.team.persistence.JourneyDao;

@SpringBootTest
class JourneyApiApplicationTests {

	@Autowired
	private JourneyDao journeyDao;

	@Test
	void contextLoads() {

		//Journey j1 = new Journey(101, 202, 203, LocalDateTime.now(), LocalDateTime.now(), 12.00, false);
		
		assertThat(journeyDao.getById(1).getStartStationId()).isEqualTo(1);

	}

}
