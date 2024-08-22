package com.gl.flightSystem.flightService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gl.flightSystem.entities.Flight;


public interface FlightService
{
    Flight addFlightDetails(Flight flight);
    Flight updateFlightDetails(Integer flightNumber,Flight flight);
    List<Flight> getAllFlightDetails();
    Flight getFlightDetails(Integer flightNumber);
    String deleteFlightDetails(Integer flightNumber);
    public Page<Flight> getAllFlights(Pageable pageable);
  
    
}
