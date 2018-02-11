package com.devnexus.workshop.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.devnexus.workshop.junit5.Earthquake.*;

public class ShakeExceptionTest {

	@Test @Disabled
	public void message() {
		String expected = "message";
		ShakeException actual = new ShakeException(expected);
		assertEquals(expected, actual.getMessage());
	}

}
