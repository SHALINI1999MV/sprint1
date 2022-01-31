package com.abc.vehiclerental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.vehiclerental.entity.CarDetails;

public interface CarRepository extends JpaRepository<CarDetails,Long> {

	public List<CarDetails> findByBrand(String brand);
	
	public List<CarDetails> findByCarType(String type);
	
	public List<CarDetails> findByColor(String color);
	
	@Query("Select c from CarDetails c where c.isBooked = false")
	public List<CarDetails> findByIsBooked();
	
}
