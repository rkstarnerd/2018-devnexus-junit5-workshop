package com.devnexus.workshop.junit5;
import static com.devnexus.workshop.junit5.ParkBuilding.*;
import static org.junit.Assert.*;

import org.junit.*;

/*
 * Clearly this test doesn't cover all the cases, but good enough to show JUnit 5 ;)
 */
public class ParkBuildingTest {

	private static ParkBuilding building1 = DOME;
	private static ParkBuilding building2 = WORLD_CONGRESS;

	@AfterClass
	public static void tearDown() {
		building1 = null;
		building2 = null;
	}

	@Test
	public void hashCodeValues() {
		assertEquals("same", building1.hashCode(), building1.hashCode());
		assertNotEquals("different", building1.hashCode(), building2.hashCode());
	}

	@Test
	public void equalsValues() {
		assertTrue("same", building1.equals(building1));
		assertFalse("null", building1.equals(null));
		assertFalse("different", building1.equals(building2));
	}

}
