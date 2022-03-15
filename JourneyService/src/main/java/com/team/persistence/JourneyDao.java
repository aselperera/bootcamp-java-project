package com.team.persistence;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.team.entity.Journey;

@Repository
public interface JourneyDao extends JpaRepository<Journey, Integer> {
	
	
	@Transactional
	@Modifying
	@Query(value="insert into Journey (userId, startStationId, applyFine) values (:userId, :startStationId, :applyFine)", nativeQuery=true)
	public int startJourney(@Param("userId") int userId, @Param("startStationId") int startStationId, @Param("applyFine") boolean applyFine);
	
	@Transactional
	@Modifying
	@Query("Update Journey set endStationId=:endStationId, endTime=:endTime, price=:price where userId=:userId")
	public int updateJourney(@Param("userId") int userId, @Param("endStationId") int endStationId, @Param("endTime") LocalDateTime endTime, @Param("price") double price);

}
