package com.abc.vehiclerental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.vehiclerental.entity.CarDetails;
import com.abc.vehiclerental.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;

	@Override
	public void addCar(CarDetails car) {
		carRepository.save(car);
	}

	@Override
	public void updateCar(CarDetails car) {
		carRepository.save(car);
	}

	@Override
	public void deleteCar(long carId) {
		carRepository.deleteById(carId);
	}

	@Override
	public List<CarDetails> searchByBrand(String brand) {
		return carRepository.findByBrand(brand);
	}

	@Override
	public List<CarDetails> searchByType(String type) {
		return carRepository.findByCarType(type);
	}

	@Override
	public List<CarDetails> searchByColor(String color) {
		return carRepository.findByColor(color);
	}
	
	@Override
	public List<CarDetails> getAllCarsByAdmin() {
		return carRepository.findAll();
	}

	@Override
	public List<CarDetails> getAllCarsByUsers() {
		return carRepository.findByIsBooked();
	}

}
