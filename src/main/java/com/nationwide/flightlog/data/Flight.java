package com.nationwide.flightlog.data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")
@NamedQuery( name = "Flight.sumAllLandings",
			query = "select sum(f.landings) from Flight f")
@NamedQuery( name = "Flight.sumAllLandingsDates",
			query = "select sum(f.landings) from Flight f where f.flightdate>=?1 and f.flightdate<=?2")
@NamedQuery( name = "Flight.sumAllFlighttime",
			query = "select sum(f.flighttime) from Flight f")
@NamedQuery(name = "Flight.sumFlighttimeDates",
			query = "select sum(f.flighttime) from Flight f where f.flightdate>=?1 and f.flightdate<=?2")
@NamedQuery(name = "Flight.sumAllFlighttimeCallsign",
			query = "select sum(f.flighttime) from Flight f where f.callsign = ?1")
@NamedQuery(name = "Flight.sumAllFlighttimeSolo",
			query = "select sum(f.flighttime) from Flight f where f.soloordual = ?1")
@NamedQuery(name = "Flight.sumAllFlighttimeSoloDates",
			query = "select sum(f.flighttime) from Flight f where f.soloordual = ?1 and f.flightdate>=?2 and f.flightdate<=?3")
@NamedQuery(name = "Flight.findMaxIdnumber",
			query = "select max(f.idnumber) from Flight f")

public class Flight {
	@Id
	private int idnumber;
	private String picture;
	private String description;
	private int flighttime;
	private Date flightdate;
	private int passengers;
	private String airfield;
	private String callsign;
	private int landings;
	private String soloordual;
	
	public Flight() {
	}

	

	public Flight(int idnumber, String picture, String description, int flighttime, Date flightdate, int passengers,
			String airfield, String callsign, int landings, String soloordual) {
		this.idnumber = idnumber;
		this.picture = picture;
		this.description = description;
		this.flighttime = flighttime;
		this.flightdate = flightdate;
		this.passengers = passengers;
		this.airfield = airfield;
		this.callsign = callsign;
		this.landings = landings;
		this.soloordual = soloordual;
	}



	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlighttime() {
		return flighttime;
	}

	public void setFlighttime(int flighttime) {
		this.flighttime = flighttime;
	}

	public Date getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getAirfield() {
		return airfield;
	}

	public void setAirfield(String airfield) {
		this.airfield = airfield;
	}



	public String getCallsign() {
		return callsign;
	}



	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}



	public int getLandings() {
		return landings;
	}



	public void setLandings(int landings) {
		this.landings = landings;
	}



	public String getSoloordual() {
		return soloordual;
	}



	public void setSoloordual(String soloordual) {
		this.soloordual = soloordual;
	}
	
}