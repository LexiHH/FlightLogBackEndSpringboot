package com.nationwide.flightlog.repos;

import java.sql.Date;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.flightlog.data.Flight;

public interface FlightRepo extends JpaRepository<Flight, Integer> {
	
	public ArrayList<Flight> findAll();
	
	public Flight findByIdnumber(int x);
	public ArrayList<Flight> findByFlighttime(int x);
	public ArrayList<Flight> findByFlightdate(Date x);
	public ArrayList<Flight> findByPassengers(int x);
	public ArrayList<Flight> findByAirfield(String x);
	public ArrayList<Flight> findByCallsign(String X);
	
	public int sumAllLandings();
	public int sumAllLandingsDates(Date D1, Date D2);
	public int sumAllFlighttime();
	public int sumAllFlighttimeCallsign(String C);
	public int sumAllFlighttimeSolo(String S);
	public int sumAllFlighttimeSoloDates(String S, Date D1, Date D2);
	public int sumFlighttimeDates(Date D1, Date D2);
	public int findMaxIdnumber();

}
