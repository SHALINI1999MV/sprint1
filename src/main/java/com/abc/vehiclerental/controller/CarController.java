package com.abc.vehiclerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.vehiclerental.entity.CarDetails;
import com.abc.vehiclerental.service.CarService;

@RestController
@RequestMapping ("/cardetails")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCar(@RequestBody CarDetails car){
		carService.addCar(car);
		return new ResponseEntity<>("Saved car information with id: " +car.getCarId(),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCar(@RequestBody CarDetails car){
		carService.updateCar(car);
		return new ResponseEntity<>("Updated car information with id: " +car.getCarId(),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id") long carId) {
		carService.deleteCar(carId);
		return new ResponseEntity<>("Car deleted Successfully.", HttpStatus.OK);
	}
	
	@GetMapping("/searchByBrand/{brand}")
	public ResponseEntity<List<CarDetails>> searchByBrand(@PathVariable("brand") String brand) {
		List<CarDetails> carListByBrand = carService.searchByBrand(brand);
		return new ResponseEntity<>(carListByBrand,HttpStatus.OK);
	}
	
	@GetMapping("/searchByType/{type}")
	public ResponseEntity<List<CarDetails>> searchByCarType(@PathVariable("type") String type) {
		List<CarDetails> carListByType = carService.searchByType(type);
		return new ResponseEntity<>(carListByType,HttpStatus.OK);
	}
	
	@GetMapping("/searchByColor/{color}")
	public ResponseEntity<List<CarDetails>> searchByColor(@PathVariable("color") String color) {
		List<CarDetails> carListByColor = carService.searchByColor(color);
		return new ResponseEntity<>(carListByColor,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCarsByAdmin")
	public ResponseEntity<List<CarDetails>> getAllCarsByAdmin() {
		List<CarDetails> carList = carService.getAllCarsByAdmin();
		return new ResponseEntity<>(carList,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCarsByUsers")
	public ResponseEntity<List<CarDetails>> getAllCarsByUsers() {
		List<CarDetails> carList = carService.getAllCarsByUsers();
		return new ResponseEntity<>(carList,HttpStatus.OK);
	}
	
}
