package com.team.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
//@JsonIgnoreProperties({ “hibernateLazyInitializer”, “handler” })
public class User {

	@Getter
	@Setter
	@Id
	private int id;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private double balance;
	
}
