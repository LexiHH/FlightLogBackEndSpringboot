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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.flightlog.data.Airfield;
import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.AirfieldRepo;
import com.nationwide.flightlog.repos.FlightRepo;
import com.nationwide.flightlog.services.AirfieldService;

@CrossOrigin(origins = "http://35.246.15.79")
@RestController
public class AirfieldController {
	
	@Autowired
	private AirfieldService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showAllAirfield")
	public ArrayList<Airfield> showAll() {
		return service.showAll();
	}
	
	@GetMapping("/filterAirfieldId/{R}")
	public Airfield showId(@PathVariable int R) {
		return service.showId(R);
	}
	
	@GetMapping("/LandingFeeLessThan/{X}")
	public ArrayList<Airfield> findLessThan(@PathVariable Float X) {
		return service.findLessThan(X);
	}
	
	@GetMapping("/LandingFeeMoreThan/{X}")
	public ArrayList<Airfield> findMoreThan(@PathVariable Float X) {
		return service.findMoreThan(X);
	}
	
	@GetMapping("/LandingFeeBetween/{X}/{Y}")
	public ArrayList<Airfield> findBetween(@PathVariable Float X, @PathVariable Float Y) {
		return service.findBetween(X, Y);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("saveAirfield/{Pic}/{Des}/{Tip}/{Pro}/{Con}/{Fee}")
	public String saveWithoutID(
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable String Tip,
			@PathVariable String Pro,
			@PathVariable String Con,
			@PathVariable float Fee) {
		return service.saveWithoutID(Pic, Des, Tip, Pro, Con, Fee);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteAirfield/{ID}")
	public String deleteAirfield(@PathVariable int ID) {
		return service.deleteAirfield(ID);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/changeAirfield/{Id}/{Pic}/{Des}/{Tips}/{Pros}/{Cons}/{Landingfee}")
	public String changeAirfield(@PathVariable int Id,
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable String Tips,
			@PathVariable String Pros,
			@PathVariable String Cons,
			@PathVariable float Landingfee) {
		return service.changeAirfield(Id, Pic, Des, Tips, Pros, Cons, Landingfee);
	}
	

}
