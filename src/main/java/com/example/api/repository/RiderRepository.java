package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long>  {

}
