package com.example.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Trips;
import com.example.api.repository.TripsRepository;


@Service
public class TripsDao {
	@Autowired
	TripsRepository tripsRepository;
	
	//to save
			public Trips save(Trips trip) {
				return tripsRepository.save(trip);
			}
			/* search all*/
			
			public List<Trips> findAll(){
				return tripsRepository.findAll();
			}
			
			
			/*get a Driver by id*/
			public Trips findOne(Long id) {
				return tripsRepository.findById(id).get();
			}
			
			
			/*delete a Driver*/
			
			public void delete(Trips trip) {
				tripsRepository.delete(trip);
			}
}
