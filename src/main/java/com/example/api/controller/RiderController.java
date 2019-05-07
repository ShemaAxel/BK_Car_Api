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

import com.example.api.dao.RiderDao;
import com.example.api.model.Rider;

@RestController
@RequestMapping("/api")
public class RiderController {
	@Autowired
	RiderDao riderDao;
	/* to save */
	@PostMapping("/riders")
	public Rider create(@Valid @RequestBody Rider rider) {
		return riderDao.save(rider);
	}
	
	/*get all */
	@GetMapping("/riders")
	public List<Rider> getAll(){
		return riderDao.findAll();
	}
	
	/*get by id*/
	@GetMapping("/riders/{id}")
	public ResponseEntity<Rider> getById(@PathVariable(value="id") Long id){
		Rider rider=riderDao.findOne(id);
		if(rider==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(rider);
	}
	
	
	/*update a user by id*/
	@PutMapping("/riders/{id}")
	public ResponseEntity<Rider> update(@PathVariable(value="id") Long id,@Valid @RequestBody Rider details){	
		Rider rider=riderDao.findOne(id);
		if(rider==null) {
			return ResponseEntity.notFound().build();
		}
		
		//all attributes
		rider.setRiderName(details.getRiderName());
		rider.setEmail(details.getEmail());
		rider.setTelephone(details.getTelephone());
		rider.setStatus(details.getStatus());	
		Rider update=riderDao.save(rider);
		return ResponseEntity.ok().body(update);		
	}
	
	
	
	/* Delete a User */
	@DeleteMapping("/riders/{id}")
	public ResponseEntity<Rider> delete(@PathVariable(value="id") Long id){
		Rider rider =riderDao.findOne(id);
		if(rider == null) {
			return ResponseEntity.notFound().build();
		}
		riderDao.delete(rider);
		return ResponseEntity.ok().build();
	}
}
