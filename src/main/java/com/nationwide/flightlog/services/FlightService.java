package com.nationwide.flightlog.services;

import java.sql.Date;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.FlightRepo;

@Component
public class FlightService {
	
	@Autowired
	private FlightRepo repo;
	
	public ArrayList<Flight> showall() {
		return repo.findAll();
	}
	
	public Flight showId(int R) {
		return repo.findByIdnumber(R);
	}
	
	public ArrayList<Flight> showFlighttime(int R) {
		return repo.findByFlighttime(R);
	}
	
	public ArrayList<Flight> showFlightdate(Date R) {
		return repo.findByFlightdate(R);
	}

	public ArrayList<Flight>showPassengers(int R) {
		return repo.findByPassengers(R);
	}
	
	public ArrayList<Flight> showAirfield(String R) {
		return repo.findByAirfield(R);
	}
	
	public ArrayList<Flight> showCallsign(String C) {
		return repo.findByCallsign(C);
	}
	
	public String saveWithoutID(String Pic, String Des, int Time, Date Dt, int Pass, String Air, String Cal, int Land, String Sol) {
		int ID = 0;
		if(Sol.contentEquals("Solo") || Sol.contentEquals("Dual")) {
		try {
			ID = repo.findMaxIdnumber()+1;
		}
		catch(Exception e) {
			ID = 1;
		}
		Flight F1 = new Flight(ID, Pic, Des, Time, Dt, Pass, Air, Cal, Land, Sol);
		repo.save(F1);
		return "New Flight Saved";
		}
		return "Must be 'Solo' or 'Dual'";
	}
	
	public String deleteFlight(int ID) {
		Flight F = repo.findByIdnumber(ID);
		repo.delete(F);
		return "Flight Deleted";
	}
	
	public String sumAllFlighttime() {
		int all = repo.sumAllFlighttime();
		int hours = all/60;
		int mins = all%60;
		return (hours + " hours and " + mins + " mins");
	}
	
	public int sumAllLandings() {
		return repo.sumAllLandings();
	}
	
	public int sumAllLandingsDates(Date D1, Date D2) {
		return repo.sumAllLandingsDates(D1, D2);
	}
	
	public String sumAllFlighttimeSolo(String S) {
		if(S.contentEquals("Solo") || S.contentEquals("Dual")) {
		int all = repo.sumAllFlighttimeSolo(S);
		int hours = all/60;
		int mins = all%60;
		return (hours + " hours and " + mins + " mins");
		}
		return "Must be 'Solo' or 'Dual'";
	}
	
	public String sumAllFlighttimeSoloDates(String S, Date D1, Date D2) {
		if(S.contentEquals("Solo") || S.contentEquals("Dual")) {
			int all = repo.sumAllFlighttimeSoloDates(S, D1, D2);
			int hours = all/60;
			int mins = all%60;
			if(hours == 0 && mins == 0) {
				return("No flight time");
			}
			return (hours + " hours and " + mins + " mins");
			}
		return "Must be 'Solo' or 'Dual'";
	}
	
	public String sumAllFlighttimeCallsign(String C) {
		try {
			int all = repo.sumAllFlighttimeCallsign(C);
			if(all > 0) {
				int hours = all/60;
				int mins = all%60;
				return (hours + " hours and " + mins + " mins");
			}
			else return "Flight Time is 0 - check callsign";
			}
			catch(Exception e) {
			return "Flight Time is 0 - check callsign";
			}
	}
	
	public String sumFlighttimeDates(Date D1, Date D2) {
		try {
		int all = repo.sumFlighttimeDates(D1, D2);
		if(all > 0) {
			int hours = all/60;
			int mins = all%60;
			return (hours + " hours and " + mins + " mins");
		}
		else return "Flight Time is 0 - check dates";
		}
		catch(Exception e) {
		return "Flight Time is 0 - check dates";
		}
	}
	
	public String changeFlight(int ID, String Pic, String Des, int Time, Date Dt, int Pass, String Air, String Cal, int Land, String Sol) {
		Flight F1 = repo.findByIdnumber(ID);
		if(F1 == null)
			return "Record not Found";
		F1.setPicture(Pic);
		F1.setDescription(Des);
		F1.setFlighttime(Time);
		F1.setFlightdate(Dt);
		F1.setAirfield(Air);
		F1.setCallsign(Cal);
		F1.setLandings(Land);
		F1.setSoloordual(Sol);
		repo.save(F1);
		return "Flight Changed";
		
	}

}
