package com.team.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Stations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Station {
	
	@Getter
	@Setter
	@Id
	@Column(name="sequence_number")
	private int sequenceNumber;
	
	@Getter
	@Setter
	@Column(name="station_name")
	private String stationName;
}
