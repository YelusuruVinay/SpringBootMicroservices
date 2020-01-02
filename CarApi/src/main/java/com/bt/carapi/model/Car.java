package com.bt.carapi.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String name;
	private int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
