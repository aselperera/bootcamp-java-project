package com.team.entity;

import java.time.LocalDateTime;

//In the webapp we are not communicating with the db, so we don't need these?
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;

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
//@Entity
public class Journey {
	
	public Journey(int userId, int startStationId, LocalDateTime startTime) {
		super();
		this.userId = userId;
		this.startStationId = startStationId;
		this.startTime = startTime;
	}
	
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
