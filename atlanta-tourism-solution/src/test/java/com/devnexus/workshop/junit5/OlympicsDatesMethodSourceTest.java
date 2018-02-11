package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class OlympicsDatesMethodSourceTest {

	@ParameterizedTest(name = "{0}")
	@MethodSource("specialDateGenerator")
	public void specialDates(LocalDate date) {
		boolean actual = OlympicsDates.isCompetitionDay(date);
		assertTrue(actual);
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("nonSpecialDateGenerator")
	public void notSpecialDates(LocalDate date) {
		boolean actual = OlympicsDates.isCompetitionDay(date);
		assertFalse(actual);
	}

	public static List<LocalDate> specialDateGenerator() {
		return Arrays.asList(LocalDate.of(1996, 7, 19), LocalDate.of(1996, 7, 20), LocalDate.of(1996, 7, 31),
				LocalDate.of(1996, 8, 3), LocalDate.of(1996, 8, 4));
	}

	public static Stream<LocalDate> nonSpecialDateGenerator() {
		return Stream.of(LocalDate.of(1996, 7, 18), LocalDate.of(1996, 8, 5), LocalDate.of(1997, 7, 18),
				LocalDate.of(1995, 8, 1));
	}

	@Test
	public void dummyTestSoRuns() {
		// no op
	}

}
