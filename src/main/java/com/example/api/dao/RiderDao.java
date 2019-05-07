package com.example.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.Rider;
import com.example.api.repository.RiderRepository;


@Service
public class RiderDao {
	@Autowired
	RiderRepository riderRepository;
	//to save
		public Rider save(Rider rider) {
			return riderRepository.save(rider);
		}
		/* search all*/
		
		public List<Rider> findAll(){
			return riderRepository.findAll();
		}
		
		
		/*get a Driver by id*/
		public Rider findOne(Long id) {
			return riderRepository.findById(id).get();
		}
		
		
		/*delete a Driver*/
		
		public void delete(Rider rider) {
			riderRepository.delete(rider);
		}
}
