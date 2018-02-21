package com.devnexus.workshop.junit5;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import com.devnexus.workshop.junit5.Earthquake.ShakeException;

public class ShakeExceptionTest {

	@Test @Disabled("this test is ignored becuase it is unnecessary")
	public void message() {
		String expected = "message";
		ShakeException actual = new ShakeException(expected);
		assertEquals(expected, actual.getMessage());
		System.out.println("Ignored Test:  This should NOT print");
	}

}
