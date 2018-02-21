package com.devnexus.workshop.junit5;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.*;
import java.time.*;

public class CentennialOlympicParkEnumParamTest {

	@Test
	public void allClosingTimesAfter9pm() {
		LocalTime ninePm = LocalTime.of(12 + 9, 0);
		for (CentennialOlympicParkEnum current : CentennialOlympicParkEnum.values()) {
			assertThat(current + " should close after 9pm", current.closes(), greaterThanOrEqualTo(ninePm));
		}
	}

}
