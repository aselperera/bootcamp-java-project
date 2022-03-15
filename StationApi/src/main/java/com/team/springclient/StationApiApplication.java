package com.team.springclient;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.team.entity.Station;
import com.team.persistence.StationDao;

*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.team")
@EntityScan(basePackages = "com.team.entity")
@EnableJpaRepositories(basePackages = "com.team.persistence")
public class StationApiApplication {
	
	/*
	@Autowired
	private StationDao stationDao;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(StationApiApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		Station s1 = new Station(1, "station_1");
		Station s2 = new Station(2, "station_2");
		Station s3 = new Station(3, "station_3");
		Station s4 = new Station(4, "station_4");
		Station s5 = new Station(5, "station_5");
		
		stationDao.save(s1);
		stationDao.save(s2);
		stationDao.save(s3);
		stationDao.save(s4);
		stationDao.save(s5);
		
	}
	*/
}
