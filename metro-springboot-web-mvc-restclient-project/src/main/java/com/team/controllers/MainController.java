package com.team.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.service.MetroService;

public class MainController {

	@Autowired
	private MetroService metroService;
	
	@RequestMapping("/")
	public String getMainPageController() {
		return "index";
	}
	
	
}
