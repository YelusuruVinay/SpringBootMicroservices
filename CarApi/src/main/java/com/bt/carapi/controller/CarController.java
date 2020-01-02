package com.bt.carapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.carapi.model.Car;
import com.bt.carapi.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService carService;

	@RequestMapping("/car/{name}")
	public Car getCar(@PathVariable String name) {

		Car car = carService.findCar(name);

		return car;
	}
}
