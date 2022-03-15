package com.team.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

//	public Journey(int id, int userId, int startStationId, LocalDateTime startTime, double price) {
//		this.id = id;
//		this.userId = userId;
//		this.startStationId = startStationId;
//		this.startTime = startTime;
//		this.price = price;
//	}
	
//	@Getter
//	@Setter
//	@Id
//	private int id;
	
	
	@Getter
	@Setter
	@Id
	private int userId;
	
	@Getter
	@Setter
	private int startStationId;
	
	@Getter
	@Setter
	@Column(nullable = true)
	private int endStationId;
	
	@Getter
	@Setter
	@Column(nullable = true)
	private LocalDateTime startTime;
	
	@Getter
	@Setter
	@Column(nullable = true)
	private LocalDateTime endTime;
	
	@Getter
	@Setter
	@Column(nullable = true)
	private double price;
	
	@Getter
	@Setter
	private boolean applyFine;

	public Journey(int userId, int startStationId, LocalDateTime startTime) {
		super();
		this.userId = userId;
		this.startStationId = startStationId;
		this.startTime = startTime;
	}

	public Journey(int userId, int startStationId) {
		super();
		this.userId = userId;
		this.startStationId = startStationId;
	}
	
	
}
