package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {

@Autowired
   VehicleService vser;


    @PostMapping("/addVehicle")
	ResponseEntity<Vehicle> addVehicle( @RequestBody Vehicle vehicle)  
	{
		return  new ResponseEntity<Vehicle>( vser.addVehicle(vehicle),HttpStatus.CREATED)  ;
	}
    
    @GetMapping("/getById")
    ResponseEntity<Vehicle> getById(@RequestHeader Integer vid)
    {
    	return new ResponseEntity<Vehicle>(vser.getById(vid), HttpStatus.FOUND);
    }
    
    @GetMapping("/getByColor")
    ResponseEntity<List<Vehicle>> getByColor(@RequestHeader String vcolor)
    {
    	return new ResponseEntity<List<Vehicle>>(vser.getByColor(vcolor), HttpStatus.FOUND );
    }
    
    
    @GetMapping("/getByName")
    ResponseEntity<List<Vehicle>> getByName(@RequestHeader String vname)
    {
    	return new ResponseEntity<List<Vehicle>>(vser.getByName(vname), HttpStatus.FOUND );
    }
    
    
    @GetMapping("/getBySorted")
    ResponseEntity<List<Vehicle>> getBySortedPrice()
    {
    	return new ResponseEntity<List<Vehicle>>(vser.getSortedByPrice(), HttpStatus.FOUND );
    }
    
    
   
    @GetMapping("/getByGtP")
    ResponseEntity<List<Vehicle>> getByPriceGt(@RequestHeader double vprice)
    {
    	return new ResponseEntity<List<Vehicle>>(vser.getVehicleGTPrice(vprice), HttpStatus.FOUND );
    }
    
    
    @PutMapping("/update")
    ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle v)
    {
    	return new ResponseEntity<Vehicle>(vser.updateById(v),HttpStatus.OK);
    }
    
    
   @DeleteMapping("/delete")
    ResponseEntity<Vehicle> deleteById(@RequestHeader Integer vid)
    {
    	return new ResponseEntity<Vehicle>(HttpStatus.OK);
    }
    
   @GetMapping("/getAllVehicles")
   ResponseEntity<List<Vehicle>> getAllVehicles()
   {
	   return new ResponseEntity<List<Vehicle>>(vser.getAllVehicle(),HttpStatus.ACCEPTED);
   }
}

