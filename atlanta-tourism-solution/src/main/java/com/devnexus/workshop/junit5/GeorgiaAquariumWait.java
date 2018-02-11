package com.devnexus.workshop.junit5;

import java.time.*;

public class GeorgiaAquariumWait {

	private GeorgiaAquariumSchedule schedule;

	public GeorgiaAquariumWait(GeorgiaAquariumSchedule schedule) {
		this.schedule = schedule;
	}

	public boolean isOpen(LocalDateTime now) {
		LocalTime openingTime = schedule.opening(now.toLocalDate());
		LocalTime currentTime = now.toLocalTime();
		return openingTime.equals(currentTime) || openingTime.isBefore(currentTime);
	}
}
