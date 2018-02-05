package com.devnexus.workshop.junit5;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.time.*;

import org.junit.*;

public class CentennialOlympicParkEnumTest {

	@Test
	public void allClosingTimesAfter9pm() {
		LocalTime ninePm = LocalTime.of(12 + 9, 0);
		for (CentennialOlympicParkEnum current : CentennialOlympicParkEnum.values()) {
			assertThat(current + " should close after 9pm", current.closes(), greaterThanOrEqualTo(ninePm));
		}
	}

}
