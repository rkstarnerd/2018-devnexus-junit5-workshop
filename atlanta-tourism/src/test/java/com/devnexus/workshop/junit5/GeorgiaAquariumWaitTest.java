package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import name.falgout.jeffrey.testing.junit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GeorgiaAquariumWaitTest {

	@Mock
	GeorgiaAquariumSchedule mockSchedule;

	private GeorgiaAquariumWait target;
	
	private LocalDate saturday;

	@BeforeEach
	public void setUp() {
		target = new GeorgiaAquariumWait(mockSchedule);
		saturday = LocalDate.of(2017,  Month.FEBRUARY, 24);
		LocalTime nineAm = LocalTime.of(9, 0);
		when(mockSchedule.opening(saturday)).thenReturn(nineAm);
	}

	@Test
	public void plentyOfTime() {
		LocalTime halfHourEarlier = LocalTime.of(8, 30);
		LocalDateTime dateTime = LocalDateTime.of(saturday, halfHourEarlier);
		assertFalse(target.isOpen(dateTime));
	}
	
	@Test
	public void anyMinuteNow() {
		LocalTime oneMinuteEarlier = LocalTime.of(8, 59);
		LocalDateTime dateTime = LocalDateTime.of(saturday, oneMinuteEarlier);
		assertFalse(target.isOpen(dateTime));
	}
	
	@Test
	public void exactOpening() {
		LocalTime sameTime = LocalTime.of(9, 00);
		LocalDateTime dateTime = LocalDateTime.of(saturday, sameTime);
		assertTrue(target.isOpen(dateTime));
	}
	
	@Test
	public void alreadyOpen() {
		LocalTime openHalfHour = LocalTime.of(9, 30);
		LocalDateTime dateTime = LocalDateTime.of(saturday, openHalfHour);
		assertTrue(target.isOpen(dateTime));
	}

}
