package com.example.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dao.DriverDao;
import com.example.api.model.Driver;
@RestController
@RequestMapping("/api")
public class DriverController {
	@Autowired
	DriverDao driverDao;
	/* to save */
	@PostMapping("/drivers")
	public Driver create(@Valid @RequestBody Driver driver) {
		return driverDao.save(driver);
	}
	
	/*get all */
	@GetMapping("/drivers")
	public List<Driver> getAll(){
		return driverDao.findAll();
	}
	
	/*get by id*/
	@GetMapping("/drivers/{id}")
	public ResponseEntity<Driver> getById(@PathVariable(value="id") Long id){
		Driver driver=driverDao.findOne(id);
		if(driver==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(driver);
	}
	
	
	/*update a user by id*/
	@PutMapping("/drivers/{id}")
	public ResponseEntity<Driver> update(@PathVariable(value="id") Long id,@Valid @RequestBody Driver details){	
		Driver driver=driverDao.findOne(id);
		if(driver==null) {
			return ResponseEntity.notFound().build();
		}
		
		//all attributes
		driver.setDriverName(details.getDriverName());
		driver.setEmail(details.getEmail());
		driver.setMsisdn(details.getMsisdn());
		driver.setStatus(details.getStatus());		
		Driver updateUser=driverDao.save(driver);
		return ResponseEntity.ok().body(updateUser);		
	}
	
	
	
	/* Delete a User */
	@DeleteMapping("/drivers/{id}")
	public ResponseEntity<Driver> delete(@PathVariable(value="id") Long id){
		
		Driver driver =driverDao.findOne(id);
		if(driver == null) {
			return ResponseEntity.notFound().build();
		}
		driverDao.delete(driver);
		return ResponseEntity.ok().build();
	}
}
