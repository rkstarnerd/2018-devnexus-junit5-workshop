package com.devnexus.workshop.junit5;

import java.time.*;

public enum CentennialOlympicParkEnum {
	PARK(23), AQUARIUM(21);

	private LocalTime closing;

	CentennialOlympicParkEnum(int closingHour) {
		closing = LocalTime.of(closingHour, 0);
	}

	public LocalTime closes() {
		return closing;
	}
}
