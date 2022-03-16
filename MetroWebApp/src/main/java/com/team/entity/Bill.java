package com.team.entity;

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
public class Bill {
	
	@Getter
	@Setter
	private String startStationName;
	
	@Getter
	@Setter
	private String endStationName;
	
	@Getter
	@Setter
	private String startTime;
	
	@Getter
	@Setter
	private String endTime;
	
	@Getter
	@Setter
	private double price;
	
	@Getter
	@Setter
	private boolean applyFine;
	
}
