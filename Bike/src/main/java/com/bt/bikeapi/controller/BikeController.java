package com.bt.bikeapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.bikeapi.models.Bike;
import com.bt.bikeapi.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	private BikeService bikeService;

	@RequestMapping("/bike/{name}")
	public Bike getBikeDetails(@PathVariable String name) {

		return bikeService.getDetails(name);

	}

	@RequestMapping("/bikes")
	public Map<String, Bike> getAllDetails() {
		return bikeService.getBikes();

	}
}
