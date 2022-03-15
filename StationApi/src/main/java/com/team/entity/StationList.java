package com.team.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class StationList {
	 
	 @Getter
	 @Setter
	 private List<Station> stationList;
}
