package com.abc.vehiclerental.service;

import java.util.List;

import com.abc.vehiclerental.entity.CarDetails;

public interface CarService {

	public void addCar(CarDetails car);

	public void updateCar(CarDetails car);
	
	public void deleteCar(long carId);

	public List<CarDetails> searchByBrand(String brand);

	public List<CarDetails> searchByType(String type);

	public List<CarDetails> searchByColor(String color);
	
	public List<CarDetails> getAllCarsByAdmin();

	public List<CarDetails> getAllCarsByUsers();
	
}
