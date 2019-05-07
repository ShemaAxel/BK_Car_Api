package com.example.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Driver;
import com.example.api.repository.DriverRepository;


@Service
public class DriverDao {

	@Autowired
	DriverRepository driverRepository;
	
	//to save
	public Driver save(Driver driver) {
		return driverRepository.save(driver);
	}
	/* search all*/
	
	public List<Driver> findAll(){
		return driverRepository.findAll();
	}
	
	
	/*get a Driver by id*/
	public Driver findOne(Long id) {
		return driverRepository.findById(id).get();
	}
	
	
	/*delete a Driver*/
	
	public void delete(Driver driver) {
		driverRepository.delete(driver);
	}
}
