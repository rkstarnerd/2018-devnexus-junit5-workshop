package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;
import java.time.*;

import org.junit.jupiter.api.*;

@Tag("slow")
public class EarthquakeTimeoutTest {

	private Earthquake earthquake;

	@BeforeEach
	public void setUp() {
		earthquake = new Earthquake();
	}

	@Test
	public void timeout() {
		assertTimeout(Duration.ofSeconds(6), () -> earthquake.waitForAftershock());
	}

}
