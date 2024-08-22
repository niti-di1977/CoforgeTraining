package com.gl.flightSystem.flightService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.gl.flightSystem.entities.Flight;
import com.gl.flightSystem.flightRepository.FlightRepository;


@Service
public class FlightServiceImpl implements FlightService
{
	@Autowired
	FlightRepository flightRepository;

	 public Page<Flight> getAllFlights(Pageable pageable) {
	        return flightRepository.findAll(pageable);
	    }

	@Override
	public Flight addFlightDetails(Flight flight) {
	 Flight flightSaved= flightRepository.save(flight);
		return flightSaved;
	}

	@Override
	public Flight updateFlightDetails(Integer flightNumber, Flight flight) {
		Flight flightUpdated;
		if(flightRepository.findById(flightNumber).get()!=null)
		{
			flightUpdated=flightRepository.save(flight);
		}
		else {
			flightUpdated= null;
		}
		
		return flightUpdated;
	}

	@Override
	public List<Flight> getAllFlightDetails() {
		return flightRepository.findAll();
	}

	@Override
	public Flight getFlightDetails(Integer flightNumber) {
		
		return flightRepository.findById(flightNumber).get();
	}

	@Override
	public String deleteFlightDetails(Integer flightNumber) {
		Flight flightToBeDeleted=flightRepository.findById(flightNumber).get();
		String deleteMessage;
		if(flightToBeDeleted!=null)
		{
			flightRepository.delete(flightToBeDeleted);
			deleteMessage="flight details deleted successfully";
		}
		else {
			deleteMessage="flight details could not be deleted";
		}
		
		return deleteMessage;
	}

}
