package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OlympicsDatesTest {
	
	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = { "1996-07-19", "1996-07-20", "1996-07-31", "1996-08-03", 
			"1996-08-04" })
	public void specialDates(String formattedDate) {
		boolean actual = OlympicsDates.isCompetitionDay(getLocalDate(formattedDate));
		assertTrue(actual);
	}
	
	@ParameterizedTest(name = "{0}")
	@ValueSource(strings = { "1996-07-18", "1996-08-05", "1997-07-18", "1995-08-01" })
	public void notSpecialDates(String formattedDate) {
		boolean actual = OlympicsDates.isCompetitionDay(getLocalDate(formattedDate));
		assertFalse(actual);
	}
	
	@Test
	public void dummyTestSoRuns() { }
	
	private LocalDate getLocalDate(String formattedDate) {
		return LocalDate.parse(formattedDate);
	}
}
