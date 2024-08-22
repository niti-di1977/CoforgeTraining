package com.gl.flightSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.flightSystem.FlightSystemApplication;
import com.gl.flightSystem.entities.Flight;
import com.gl.flightSystem.flightRepository.FlightRepository;
import com.gl.flightSystem.flightService.FlightService;

@SuppressWarnings("deprecation")
@SpringBootTest(classes=FlightSystemApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightServiceIntegrationTest {


    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testGetAllFlights() {
        // Save dummy data to the database
        Flight flight1 = new Flight();
        flight1.setFlightNumber(101);
        flight1.setFlightName("Flight 101");
        flight1.setArrival("Airport A");
        flight1.setDeparture("Airport B");
        flight1.setJourney("1 hours");

        Flight flight2 = new Flight();
        flight2.setFlightNumber(102);
        flight2.setFlightName("Flight 102");
        flight2.setArrival("Airport C");
        flight2.setDeparture("Airport D");
        flight2.setJourney("2 hours");

        flightRepository.saveAll(List.of(flight1, flight2));

        // Test the getAllFlights method
        Pageable pageable = PageRequest.of(0, 10);
        Page<Flight> result = flightService.getAllFlights(pageable);

        // Assert that the result contains the expected flights
        assertEquals(32, result.getTotalElements());
        assertEquals("Flight 101", result.getContent().get(0).getFlightName());
        assertEquals("Flight 8", result.getContent().get(9).getFlightName());
        assertThrows(IndexOutOfBoundsException.class,()->result.getContent().get(10).getFlightName());
    }
    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllFlightsPagedAndSorted() {
        // Perform GET request with pagination and sorting parameters
        String url = "http://localhost:" + port + "/flight.com/all-flights-paged?page=0&size=10&sortBy=flightNumber&sortDirection=asc";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Assert the status code
        assertEquals(HttpStatus.OK, response.getStatusCode());

      List<Flight> flights= null;
		try {
			 flights = objectMapper.readValue(response.getBody(), new TypeReference<>() {});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Add assertions based on the sorting order
        assertTrue(isSortedByFlightNumberAscending(flights));
    }
    private boolean isSortedByFlightNumberAscending(List<Flight> flights) {
        for (int i = 0; i < flights.size() - 1; i++) {
            if ((flights.get(i)).getFlightNumber() > flights.get(i+1).getFlightNumber()) {
                return false;
            }
        }
        return true;
    }
}
