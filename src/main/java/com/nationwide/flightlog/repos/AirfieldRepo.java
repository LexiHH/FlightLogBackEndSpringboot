package com.nationwide.flightlog.repos;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.flightlog.data.Airfield;
import com.nationwide.flightlog.data.Flight;

public interface AirfieldRepo extends JpaRepository<Airfield, Integer> {
	
	public ArrayList<Airfield> findAll();
	
	public Airfield findByIdnumber(int x);

	public ArrayList<Airfield> findByLandingfeeGreaterThan(float x);
	public ArrayList<Airfield> findByLandingfeeLessThan(float x);
	public ArrayList<Airfield> findByLandingfeeBetween(float x, float y);
	
	public int findMaxIdnumber();
}
