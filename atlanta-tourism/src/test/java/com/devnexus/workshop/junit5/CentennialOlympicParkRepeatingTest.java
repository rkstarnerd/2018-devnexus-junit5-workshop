package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Repeating vs Parameterized")
public class CentennialOlympicParkRepeatingTest {

	@DisplayName("Repeating tests")
	@RepeatedTest(value=100)
	public void tooEarly() {
		assertFalse(OlympicsDates.isCompetitionDay(LocalDate.parse("2015-01-02")));
	}
	
	@DisplayName("Randmon repeating tests")
	@ParameterizedTest
	@MethodSource("randomDatesIn2015")
	public void stillTooEarly(LocalDate date){
		assertFalse(OlympicsDates.isCompetitionDay(date));
	}
	
	static List<LocalDate> randomDatesIn2015() {
		Random random = new Random();
		LocalDate firstOfYear = LocalDate.of(2015, Month.JANUARY, 1);
		return IntStream.generate(() -> random.nextInt(365))
					    .mapToObj(n  -> firstOfYear.plusDays(n))
					    .limit(100)
					    .collect(Collectors.toList());
	}
}
