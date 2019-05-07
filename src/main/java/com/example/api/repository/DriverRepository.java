package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Driver;



public interface DriverRepository  extends JpaRepository<Driver, Long> {

}
