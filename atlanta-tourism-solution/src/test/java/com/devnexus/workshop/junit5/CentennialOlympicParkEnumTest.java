package com.devnexus.workshop.junit5;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.time.*;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class CentennialOlympicParkEnumTest {

	@ParameterizedTest
	@EnumSource(CentennialOlympicParkEnum.class)
	public void allClosingTimesAfter9pm(CentennialOlympicParkEnum current) {
		LocalTime ninePm = LocalTime.of(12 + 9, 0);
		assertThat(current + " should close after 9pm", current.closes(), greaterThanOrEqualTo(ninePm));
	}

}
