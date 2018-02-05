package com.devnexus.workshop.junit5;

import java.util.*;

public class CentennialOlympicPark {

	private List<ParkBuilding> buildings;

	public CentennialOlympicPark() {
		buildings = new ArrayList<>();
	}

	public String getUrl() {
		return "https://www.gwcca.org/park/";
	}

	public void addBuilding(ParkBuilding s) {
		buildings.add(s);
	}

	public Optional<ParkBuilding> getOldestBuilding() {
		return buildings.stream().max((s1, s2) -> s2.getAge() - s1.getAge());
	}
}
