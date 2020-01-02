package com.bt.carapi.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.bt.carapi.model.Car;

@Service
public class CarService {
	private static Map<String, Car> cars = new HashMap();

	@PostConstruct
	public void initCars() {

		Car car = new Car();
		car.setName("bmw");
		car.setRating(5);
		cars.put(car.getName(), car);
		Car car1 = new Car();
		car1.setName("audi");
		car1.setRating(3);
		cars.put(car.getName(), car);
	}

	public Car findCar(String name) {
		return cars.get(name);
	}
}
