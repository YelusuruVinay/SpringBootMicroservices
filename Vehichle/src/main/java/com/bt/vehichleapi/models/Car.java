package com.bt.vehichleapi.models;

import org.springframework.stereotype.Component;

@Component
public class Car extends Vehichle {
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
