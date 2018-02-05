package com.devnexus.workshop.junit5;

import org.junit.*;

import com.devnexus.workshop.junit5.Earthquake;

public class EarthquakeTimeoutTest {

	private Earthquake earthquake;

	@Before
	public void setUp() {
		earthquake = new Earthquake();
	}

	@Test(timeout = 6000)
	public void timeout() {
		earthquake.waitForAftershock();
	}

}
