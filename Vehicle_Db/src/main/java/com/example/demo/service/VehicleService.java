package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Vehicle;

public interface VehicleService {

	Vehicle addVehicle(Vehicle vehicle);
	Vehicle  getById(Integer vid);
	List<Vehicle> getByName(String name);
	List<Vehicle> getByModel(String vmodel);
	List<Vehicle> getByColor(String color);
	List<Vehicle> getSortedByPrice();
	List<Vehicle> getVehicleGTPrice(double price);
	List<Vehicle> getAllVehicle();
	Vehicle updateById(Vehicle vehicle);
	void deleteById(Integer vid);
	
	
}
