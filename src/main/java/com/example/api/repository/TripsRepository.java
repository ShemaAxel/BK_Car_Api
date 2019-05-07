package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Trips;

public interface TripsRepository extends JpaRepository<Trips, Long> {

}
