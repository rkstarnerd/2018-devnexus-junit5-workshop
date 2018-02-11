package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class OlympicsDatesTest {
	
	@ParameterizedTest(name = "{0}")
	@CsvFileSource(resources = { "/olympics-tests.txt" })
	public void date(LocalDate date, boolean expectedResult) {
		boolean actual = OlympicsDates.isCompetitionDay(date);
		assertEquals(expectedResult, actual);
	}

}
