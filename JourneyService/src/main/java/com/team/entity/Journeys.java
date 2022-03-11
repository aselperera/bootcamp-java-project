package com.team.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Journeys {
	
	@Getter
	@Setter
	List<Journey> journeyList;

}
