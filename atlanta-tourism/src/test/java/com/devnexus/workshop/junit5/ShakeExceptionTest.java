package com.devnexus.workshop.junit5;

import static org.junit.Assert.*;

import org.junit.*;

import com.devnexus.workshop.junit5.Earthquake.*;

public class ShakeExceptionTest {

	@Test @Ignore("this test is ignored becuase it is unnecessary")
	public void message() {
		String expected = "message";
		ShakeException actual = new ShakeException(expected);
		assertEquals(expected, actual.getMessage());
	}

}
