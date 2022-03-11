package com.team.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Journey {
//	@Getter
//	@Setter
//	@Id
//	private int journeyId;
	
	
	@Getter
	@Setter
	private int userId;
	
	@Getter
	@Setter
	private int startStationId;
	
	@Getter
	@Setter
	private int endStationId;
	
	@Getter
	@Setter
	private LocalDateTime startTime;
	
	@Getter
	@Setter
	private LocalDateTime endTime;
	
	@Getter
	@Setter
	private double price;
	
	@Getter
	@Setter
	private boolean applyFine;
}
