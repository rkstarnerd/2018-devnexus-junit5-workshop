package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GeorgiaAquariumTest {

	@Test
	public void numberLines() {
		int actual = GeorgiaAquarium.getNumberShows();
		assertEquals(2, actual);
	}
	
	@Test
	public void namesOfShows() {
		assertAll( "lines", 
			() -> assertTrue(GeorgiaAquarium.isShow("Dolphin"),   "Dolphin"),
			() -> assertTrue(GeorgiaAquarium.isShow("Sea Lion"),  "Sea Lion"),
			() -> assertFalse(GeorgiaAquarium.isShow("Starfish"), "Starfish")
		);
	}

}
