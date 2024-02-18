package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VehicleRepository;
import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repo;
	
	@Override
	public Vehicle getById(Integer vid) {
		
		return repo.findById(vid).orElseThrow(()->new VehicleNotFoundException("Vehicle"," Id ",vid));
	}

	@Override
	public List<Vehicle> getByName(String name) {
		
		return repo.findByVname(name);
	}
	@Override
	public List<Vehicle> getByModel(String vmodel) {
		
		return repo.findByVmodel(vmodel);
	}

	@Override
	public List<Vehicle> getByColor(String color) {
		
		return repo.findByVcolor(color);
	}

	@Override
	public List<Vehicle> getSortedByPrice() {
		
		return repo.findBySortedPrice();
	}

	@Override
	public List<Vehicle> getVehicleGTPrice(double price) {
		
		return repo.findByPriceGT(price);
	}



	@Override
	public Vehicle updateById(Vehicle v) {
		Vehicle vehicle=repo.findById(v.getVid()).orElse(null);
		if(vehicle!=null) {
		vehicle.setVname(v.getVname());
		vehicle.setVcolor(v.getVcolor());
		vehicle.setVmodel(v.getVcolor());
		
		vehicle.setVprice(v.getVprice());
		return repo.save(vehicle);
		}
		else
		{
			throw new VehicleNotFoundException("Vehicle","id", v.getVid());
		}
		
	}

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		
		return repo.save(vehicle);
	}
	

	
	@Override
	public List<Vehicle> getAllVehicle() {
		
		return repo.findAll();
	}

	@Override
	public void deleteById(Integer vid) {
		repo.deleteById(vid);
		System.out.println("deleted Successfully");
		
	}

}
