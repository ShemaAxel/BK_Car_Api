package com.example.api.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RestController
@RequestMapping("/api")
public class TripsController {
	OkHttpClient client = new OkHttpClient();
	@Autowired
	TripsDao tripDao;
	/* to save */
	@PostMapping("/trips")
	public Trips create(@Valid @RequestBody Trips trip) {
		
		
		try {
			String response = this.calculate(trip.getDepartureLat(), trip.getDepartureLong(), trip.getDestinationLat(), trip.getDestinationLong());
			System.out.println(response);
			 JSONParser parser = new JSONParser();
	         Object obj = parser.parse(response);
	         JSONObject jsonobj=(JSONObject)obj;
	         JSONArray dist=(JSONArray)jsonobj.get("rows");
	         JSONObject obj2 = (JSONObject)dist.get(0);
	         JSONArray disting=(JSONArray)obj2.get("elements");
	         JSONObject obj3 = (JSONObject)disting.get(0);
	         JSONObject obj4=(JSONObject)obj3.get("distance");
	         //JSONObject duration=(JSONObject)obj3.get("duration");
	         String distance = (String) obj4.get("text");
	         double realDistance =Double.parseDouble(distance.substring(0, distance.length()-3));
	         trip.setDistance(realDistance);
	         trip.setDueAmount(realDistance*300);//business logic
	         
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
//		trip.setRiderId(details.getRiderId());
//		trip.setDriverId(details.getDriverId());
		trip.setDestinationLat(details.getDestinationLat());
		trip.setDestinationLong(details.getDestinationLong());
		trip.setDepartureLong(details.getDestinationLong());
		trip.setDepartureLat(details.getDepartureLat());
		trip.setStatus(details.getStatus());
		trip.setDueAmount(details.getDueAmount());
		trip.setPendingAmount(details.getPendingAmount());
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
	
	//google matrix api
	public String calculate(double depLat,double depLong,double destLat,double dstLong) throws IOException {
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+depLat+","+depLong+"&destinations="+destLat+","+depLong+"&key=AIzaSyDUYbTR-3PDWPhgxjENs4yf35g2eHc641s";
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	
}
