package com.team.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

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
	
	@Id
	@Getter
	@Setter
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

	public Journey(int userId, int startStationId) {
		
		this.userId = userId;
		this.startStationId = startStationId;
		
	}
}
