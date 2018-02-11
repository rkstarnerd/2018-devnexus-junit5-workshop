package com.devnexus.workshop.junit5;
import static com.devnexus.workshop.junit5.ParkBuilding.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/*
 * Clearly this test doesn't cover all the cases, but good enough to show JUnit 5 ;)
 */
public class ParkBuildingTest {

	private static ParkBuilding building1 = DOME;
	private static ParkBuilding building2 = WORLD_CONGRESS;

	@AfterAll
	public static void tearDown() {
		building1 = null;
		building2 = null;
	}

	@Test
	public void hashCodeValues() {
		assertEquals(building1.hashCode(), building1.hashCode(), "same");
		assertNotEquals(building1.hashCode(), building2.hashCode(), "different");
	}

	@Test
	public void equalsValues() {
		assertTrue(building1.equals(building1), "same");
		assertFalse(building1.equals(null), "null");
		assertFalse(building1.equals(building2), "different");
	}

}
