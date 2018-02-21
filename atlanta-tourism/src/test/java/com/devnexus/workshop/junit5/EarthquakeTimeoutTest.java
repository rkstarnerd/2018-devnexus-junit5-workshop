package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class EarthquakeTimeoutTest {

	private Earthquake earthquake;

	@BeforeEach
	public void setUp() {
		earthquake = new Earthquake();
	}

	@Disabled
	@Test
	public void timeout() {
		assertTimeout(Duration.ofMillis(2009),
			() -> earthquake.waitForAftershock());
		System.out.println("*****TEST*****");
	}
}
