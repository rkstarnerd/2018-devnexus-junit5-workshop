package com.devnexus.workshop.junit5;

import java.time.*;

/**
 * The Olympics in Atlanta was July 19 to Aug. 4, 1996.
 *
 */
public class OlympicsDates {

	private static final LocalDate START = LocalDate.of(1996, Month.JULY, 19);
	private static final LocalDate END = LocalDate.of(1996, Month.AUGUST, 4);

	private OlympicsDates() {
		super();
	}

	public static boolean isCompetitionDay(LocalDate date) {
		return ! date.isBefore(START) && ! date.isAfter(END); 
	}

}
