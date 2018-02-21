package com.devnexus.workshop.junit5;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devnexus.workshop.junit5.Earthquake.ShakeException;

public class EarthquakeTest {

	private Earthquake earthquake;

	@BeforeEach
	public void setUp() {
		earthquake = new Earthquake();
	}

	@Test
	public void usingStandalone() {
		assertThrows(ShakeException.class, () -> earthquake.shake(true));
	}

}
