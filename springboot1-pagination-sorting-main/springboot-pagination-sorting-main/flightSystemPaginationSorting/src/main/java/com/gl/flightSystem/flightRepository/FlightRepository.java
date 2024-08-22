package com.gl.flightSystem.flightRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.flightSystem.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	 // create appropriate method here
	
	
         	Page<Flight> findAll(Pageable pageable);
	

}
