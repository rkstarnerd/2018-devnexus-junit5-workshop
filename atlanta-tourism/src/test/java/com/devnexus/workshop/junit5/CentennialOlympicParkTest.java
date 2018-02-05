package com.devnexus.workshop.junit5;

import static org.junit.Assert.*;

import org.junit.*;

public class CentennialOlympicParkTest {

	private CentennialOlympicPark park;

	@Before
	public void createWharf() {
		park = new CentennialOlympicPark();
	}

	@Test
	public void url() {
		assertEquals("url", "https://www.gwcca.org/park/", park.getUrl());
	}
	
	@Test
	public void oldestForEmptyList() {
		assertFalse(park.getOldestBuilding().isPresent());
	}
	
	@Test
	public void oldestForFirstElement() {
		park.addBuilding(ParkBuilding.DOME);
		park.addBuilding(ParkBuilding.WORLD_CONGRESS);
		ParkBuilding actual = park.getOldestBuilding().get();
		assertEquals(1976, actual.getAge());
	}
	
	@Test
	public void oldestForLastElement() {
		park.addBuilding(ParkBuilding.WORLD_CONGRESS);
		park.addBuilding(ParkBuilding.DOME);
		ParkBuilding actual = park.getOldestBuilding().get();
		assertEquals("oldest", 1976, actual.getAge());
	}

}
