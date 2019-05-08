package com.example.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Trips {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tripId;
	private int driverId;
	private int riderId;
	private float departureLat;
	private float departureLong;
	private float destinationLat;
	private float destinationLong;
	private double distance;
	private double amount;
	private int status;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifiedAt = new Date();

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getRiderId() {
		return riderId;
	}

	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public float getDepartureLat() {
		return departureLat;
	}

	public void setDepartureLat(float departureLat) {
		this.departureLat = departureLat;
	}

	public float getDepartureLong() {
		return departureLong;
	}

	public void setDepartureLong(float departureLong) {
		this.departureLong = departureLong;
	}

	public float getDestinationLat() {
		return destinationLat;
	}

	public void setDestinationLat(float destinationLat) {
		this.destinationLat = destinationLat;
	}

	public float getDestinationLong() {
		return destinationLong;
	}

	public void setDestinationLong(float destinationLong) {
		this.destinationLong = destinationLong;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
