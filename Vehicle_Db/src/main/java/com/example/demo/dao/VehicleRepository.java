package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicle;


public interface VehicleRepository extends 	JpaRepository<Vehicle, Integer> {

	@Query(value="select * from Vehicle where vcolor=?1",nativeQuery=true)
	List<Vehicle>  findByVcolor(String vcolor);
	@Query(value="select * from Vehicle where vmodel=?1",nativeQuery=true)
	List<Vehicle> findByVmodel(String vmodel);
	@Query(value="select * from Vehicle where vname=?1",nativeQuery=true)
	List<Vehicle> findByVname(String vname);
	@Query(value="select * from Vehicle where vprice=?1",nativeQuery=true)
	List<Vehicle> findByVprice(double vprice);
	@Query(value="select * from Vehicle where vprice>?1",nativeQuery=true)
	List<Vehicle> findByPriceGT(double vprice);
	@Query(value="select * from Vehicle order By vprice asc",nativeQuery=true)
	List<Vehicle> findBySortedPrice();
	@Query(value="select * from Vehicle",nativeQuery = true)
	List<Vehicle> findByAll();
	
	@Query(value="delete from Vehicle where vid=?1")
	void deleteById(Integer vid);
	
}
