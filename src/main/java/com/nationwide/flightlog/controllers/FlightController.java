package com.nationwide.flightlog.controllers;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.FlightRepo;
import com.nationwide.flightlog.services.FlightService;


@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showAllFlight")
	public ArrayList<Flight> showall() {
		return service.showall();
	}
	
	@GetMapping("/filterFlightId/{R}")
	public Flight showId(@PathVariable int R) {
		return service.showId(R);
	}
	
	@GetMapping("/filterTime/{R}")
	public ArrayList<Flight> showFlighttime(@PathVariable int R) {
		return service.showFlighttime(R);
	}
	
	@GetMapping("/filterDate/{R}")
	public ArrayList<Flight> showFlightdate(@PathVariable Date R) {
		return service.showFlightdate(R);
	}
	
	@GetMapping("/filterPassengers/{R}")
	public ArrayList<Flight>showPassengers(@PathVariable int R) {
		return service.showPassengers(R);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/filterAirfield/{R}")
	public ArrayList<Flight> showAirfield(@PathVariable String R) {
		return service.showAirfield(R);
	}
	
	@GetMapping("/filterCallsign/{C}")
	public ArrayList<Flight> showCallsign(@PathVariable String C) {
		return service.showCallsign(C);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveFlight/{Pic}/{Des}/{Time}/{Dt}/{Pass}/{Air}/{Cal}/{Land}/{Sol}")
	public String saveWithoutID(
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable int Time,
			@PathVariable Date Dt,
			@PathVariable int Pass,
			@PathVariable String Air,
			@PathVariable String Cal,
			@PathVariable int Land,
			@PathVariable String Sol) {
		return service.saveWithoutID(Pic, Des, Time, Dt, Pass, Air, Cal, Land, Sol);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteFlight/{ID}")
	public String deleteFlight(@PathVariable int ID) {
		return service.deleteFlight(ID);
	}
	
	@GetMapping("/sumAllLandings") 
	public int sumAllLandings() {
		return service.sumAllLandings();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/sumAllLandingsDates/{D1}/{D2}")
	public int sumAllLandingsDates(@PathVariable Date D1, @PathVariable Date D2) {
		return service.sumAllLandingsDates(D1, D2);
	}

	@GetMapping("/sumAllFlighttime")
	public String sumAllFlighttime() {
		return service.sumAllFlighttime();
	}
	
	@GetMapping("/sumAllFlighttimeSolo/{S}")
	public String sumAllFlighttimeSolo(@PathVariable String S) {
		return service.sumAllFlighttimeSolo(S);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/sumAllFlighttimeSoloDates/{S}/{D1}/{D2}")
	public String sumAllFlighttimeSoloDates(@PathVariable String S, @PathVariable Date D1, @PathVariable Date D2) {
		return service.sumAllFlighttimeSoloDates(S, D1, D2);
	}
	
	@GetMapping("/sumAllFlighttimeCallsign/{C}")
	public String sumAllFlighttimeCallsign(@PathVariable String C) {
		return service.sumAllFlighttimeCallsign(C);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/sumFlighttimeBetween/{D1}/{D2}")
	public String sumFlighttimeBetween(@PathVariable Date D1, @PathVariable Date D2) {
		return service.sumFlighttimeDates(D1, D2);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/changeFlight/{Id}/{Pic}/{Des}/{Time}/{Dt}/{Pass}/{Air}/{Cal}/{Land}/{Sol}")
	public String changeFlight(@PathVariable int Id,
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable int Time,
			@PathVariable Date Dt,
			@PathVariable int Pass,
			@PathVariable String Air,
			@PathVariable String Cal,
			@PathVariable int Land,
			@PathVariable String Sol) {
		return service.changeFlight(Id, Pic, Des, Time, Dt, Pass, Air, Cal, Land, Sol);
	}

}
