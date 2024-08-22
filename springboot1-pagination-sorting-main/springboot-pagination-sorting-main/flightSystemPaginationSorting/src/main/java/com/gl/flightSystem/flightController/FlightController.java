package com.gl.flightSystem.flightController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.flightSystem.entities.Flight;
import com.gl.flightSystem.flightService.FlightService;

//http://localhost:8080/flight.com/all-flights-paged?page=0&size=10&sortBy=flightNumber&sortDirection=asc
@RestController
@RequestMapping("/flight.com")
public class FlightController 
{
	@Autowired
	FlightService flightService;
	//30 records are there in the list 
	 @GetMapping("/all-flights-paged")
	    public ResponseEntity<Page<Flight>> getAllFlights(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "flightNumber") String sortBy,
	            @RequestParam(defaultValue = "asc") String sortDirection) 
	 
	 {
		 Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));
		 
		 Page<Flight> flights = flightService.getAllFlights(pageable);
		 
         List<Flight> flightsList= flights.getContent();
          return new ResponseEntity<>(flights, HttpStatus.OK);
	    }

	@PostMapping("/addFlight")
	public Flight addFlightDetails(@RequestBody Flight flight) {
		Flight flightSaved= flightService.addFlightDetails(flight);
		return flightSaved;
	}
	
	@PutMapping("/updateFlight/{flightNumber}")
	public Flight updateFlightDetails(@PathVariable Integer flightNumber, @RequestBody Flight flight) {
		Flight flightUpdated=flightService.updateFlightDetails(flightNumber, flight);


		return flightUpdated;
	}
	@GetMapping("/allFlights")
	public List<Flight> getAllFlightDetails() {
		return flightService.getAllFlightDetails();
	}


	@GetMapping("/flight/{flightNumber}")
	public Flight getFlightDetails(@PathVariable Integer flightNumber) {

		return flightService.getFlightDetails(flightNumber);
	}
 
    @DeleteMapping("/deleteFlight/{flightNumber}")
	public String deleteFlightDetails(@PathVariable Integer flightNumber) {

		String deleteMessage;

		deleteMessage=flightService.deleteFlightDetails(flightNumber);

		return deleteMessage;
	}
    
}
