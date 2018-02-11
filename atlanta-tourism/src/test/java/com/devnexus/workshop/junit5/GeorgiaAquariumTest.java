package com.devnexus.workshop.junit5;

import static org.junit.Assert.*;

import org.assertj.core.api.*;
import org.junit.*;

public class GeorgiaAquariumTest {

	@Test
	public void numberLines() {
		int actual = GeorgiaAquarium.getNumberShows();
		assertEquals(2, actual);
	}
	
	@Test
	public void namesOfShows() {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(GeorgiaAquarium.isShow("Dolphin")).isTrue().as("Dolphin");
		softly.assertThat(GeorgiaAquarium.isShow("Sea Lion")).isTrue().as("Sea Lion");
		softly.assertThat(GeorgiaAquarium.isShow("Starfish")).isFalse().as("Starfish");
		softly.assertAll();
	}

}
