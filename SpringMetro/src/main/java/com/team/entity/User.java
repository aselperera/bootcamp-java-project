package com.team.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Getter
	@Setter
	@Id
	private int id;
	
	
}
