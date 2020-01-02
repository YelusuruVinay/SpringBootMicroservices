package com.bt.vehichleapi.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bt.vehichleapi.models.Bike;
import com.bt.vehichleapi.models.Car;
import com.bt.vehichleapi.models.Vehichle;

@RestController
public class VehichleController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/vehichle/{vehichleName}/{companyName}")
	public Vehichle getVehichleDetails(@PathVariable String vehichleName, @PathVariable String companyName) {

		if (vehichleName.equals("car")) {
			ServiceInstance service = loadBalancerClient.choose("CAR_SERVICE");

			String baseURL = service.getUri().toString();
			System.out.println("baseURL-------------------------------" + baseURL);
			RestTemplate restTemplate = new RestTemplate();
			Car car = restTemplate.getForObject(baseURL + "/car/" + companyName, Car.class);
			return car;
		}

		if (vehichleName.equals("bike")) {
			List<ServiceInstance> instance = discoveryClient.getInstances("BIKE_SERVICE");
			ServiceInstance service = instance.get(0);

			String baseURL = service.getUri().toString();
			System.out.println("baseURL-------------------------------" + baseURL);
			RestTemplate restTemplate = new RestTemplate();
			Bike bike = restTemplate.getForObject(baseURL + "/bike/" + companyName, Bike.class);
			return bike;
		}

		return new Vehichle();

	}

	@RequestMapping("/vehichle/{vehichleName}")
	public ResponseEntity<Map> getVehicles(@PathVariable String vehichleName) {
		if (vehichleName.equals("bikes")) {
			ServiceInstance service = loadBalancerClient.choose("BIKE_SERVICE");

			String baseURL = service.getUri().toString();
			System.out.println("baseURL-------------------------------" + baseURL);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> bike = restTemplate.getForEntity(baseURL + "/" + vehichleName, Map.class);
			return bike;
		}
		return null;

	}
}
