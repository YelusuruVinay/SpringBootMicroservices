package com.bt.vehichleapi.models;

import org.springframework.stereotype.Component;

@Component
public class Vehichle {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
