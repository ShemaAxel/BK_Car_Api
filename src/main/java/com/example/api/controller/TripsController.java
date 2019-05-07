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
import com.example.api.dao.TripsDao;
import com.example.api.model.Trips;

@RestController
@RequestMapping("/api")
public class TripsController {
	@Autowired
	TripsDao tripDao;
	/* to save */
	@PostMapping("/trips")
	public Trips create(@Valid @RequestBody Trips trip) {
		return tripDao.save(trip);
	}
	
	/*get all */
	@GetMapping("/trips")
	public List<Trips> getAll(){
		return tripDao.findAll();
	}
	
	/*get by id*/
	@GetMapping("/trips/{id}")
	public ResponseEntity<Trips> getById(@PathVariable(value="id") Long id){
		Trips trip=tripDao.findOne(id);
		if(trip==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(trip);
	}
	
	
	/*update a user by id*/
	@PutMapping("/trips/{id}")
	public ResponseEntity<Trips> update(@PathVariable(value="id") Long id,@Valid @RequestBody Trips details){	
		Trips trip=tripDao.findOne(id);
		if(trip==null) {
			return ResponseEntity.notFound().build();
		}
		
		//all attributes
		
		trip.setRiderId(details.getRiderId());
		trip.setDriverId(details.getDriverId());
		trip.setDeparture(details.getDeparture());
		trip.setStatus(details.getStatus());
		trip.setAmount(details.getAmount());
		trip.setDeparture(details.getDeparture());
		trip.setDestination(details.getDestination());
		trip.setDistance(details.getDistance());
		Trips update=tripDao.save(trip);
		return ResponseEntity.ok().body(update);		
	}
	
	
	
	/* Delete a User */
	@DeleteMapping("/trips/{id}")
	public ResponseEntity<Trips> delete(@PathVariable(value="id") Long id){
		Trips trip =tripDao.findOne(id);
		if(trip == null) {
			return ResponseEntity.notFound().build();
		}
		tripDao.delete(trip);
		return ResponseEntity.ok().build();
	}
}
