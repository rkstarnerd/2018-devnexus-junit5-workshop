package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

@DisplayName("Repeating vs Parameterized")
public class CentennialOlympicParkRepeatingTest {

	@DisplayName("Repeating tests")
	@RepeatedTest(value=100)
	void tooEarly() {
		Random random = new Random();
		int dayOfYear = random.nextInt(365);
		LocalDate firstOfYear = LocalDate.of(1995, Month.JANUARY, 1);
		LocalDate date = firstOfYear.plusDays(dayOfYear);
		assertFalse(OlympicsDates.isCompetitionDay(date));
	}
	
	@DisplayName("π is fun. Even \uD83D\uDE38 like π.")
	@ParameterizedTest
	@MethodSource("randomDatesIn2015")
	void stillTooEarly(LocalDate date) {
		assertFalse(OlympicsDates.isCompetitionDay(date));
	}
	
	static List<LocalDate> randomDatesIn2015() {
		Random random = new Random();
		LocalDate firstOfYear = LocalDate.of(2015, Month.JANUARY, 1);
		return IntStream.generate(() -> random.nextInt(365))
				.mapToObj(n -> firstOfYear.plusDays(n))
				.limit(100)
				.collect(Collectors.toList());
	}

}
