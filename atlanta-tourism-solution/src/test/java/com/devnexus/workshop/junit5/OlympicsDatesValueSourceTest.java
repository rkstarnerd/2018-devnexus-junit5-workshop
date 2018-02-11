package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class OlympicsDatesValueSourceTest {

	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = { "1996-07-19", "1996-07-20", "1996-07-31", "1996-08-03", "1996-08-04" })
	public void specialDates(String formattedDate) {
		LocalDate date = LocalDate.parse(formattedDate);
		boolean actual = OlympicsDates.isCompetitionDay(date);
		assertTrue(actual);
	}

	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = { "1996-07-18", "1996-08-05", "1997-07-18", "1995-08-01" })
	public void notSpecialDates(String formattedDate) {
		LocalDate date = LocalDate.parse(formattedDate);
		boolean actual = OlympicsDates.isCompetitionDay(date);
		assertFalse(actual);
	}

	@Test
	public void dummyTestSoRuns() {
		// no op
	}

}
