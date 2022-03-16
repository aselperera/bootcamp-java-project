package com.team.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.entity.Journey;

@Repository
public interface JourneyDao extends JpaRepository<Journey, Integer> {
	
}
