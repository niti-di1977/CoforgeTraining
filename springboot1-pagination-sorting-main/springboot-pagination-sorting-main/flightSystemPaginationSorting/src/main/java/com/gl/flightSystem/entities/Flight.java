package com.gl.flightSystem.entities;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Flight 
{
	@Id
	private Integer flightNumber;
	private String  flightName;
	private String  arrival;
	private String  departure;
	private String  journey;
	
	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", arrival=" + arrival + ", departure=" + departure + ", journey="
				+ journey + ", flightNumber=" + flightNumber + "]";
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getJourney() {
		return journey;
	}
	public void setJourney(String journey) {
		this.journey = journey;
	}
	
	

}
