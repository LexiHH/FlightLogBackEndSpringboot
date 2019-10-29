package com.nationwide.flightlog;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.nationwide.flightlog.controllers.FlightController;

@RunWith(SpringRunner.class)

class FlightLogApplicationTests {


	@Test
	public void sumFlighttimeTest() {
		FlightController FC = new FlightController();
		assertEquals("Sum Failed", "34 hours and 50 mins", FC.sumAllFlighttime());
		
	}

}
