package com.bt.bikeapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.bt.bikeapi.models.Bike;

@Service
public class BikeService {

	private static Map<String, Bike> bikes = new HashMap<String, Bike>();

	@PostConstruct
	public void initData() {
		Bike bike = new Bike();
		bike.setName("ktm");
		bike.setPrice(130000);
		bike.setRating(5);
		bikes.put(bike.getName(), bike);

		bike.setName("bullet");
		bike.setPrice(140000);
		bike.setRating(4);

		bikes.put(bike.getName(), bike);

	}

	public Bike getDetails(String name) {

		return bikes.get(name);

	}

	public Map<String, Bike> getBikes() {
		
		return bikes;
	}
}
