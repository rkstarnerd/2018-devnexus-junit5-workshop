package com.devnexus.workshop.junit5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FromScratchTest {

	@BeforeEach
	public void setUp() {
		assertThat(System.getProperty("os.name"), is("Mac OS X"));
	}
	
	@ParameterizedTest
	@MethodSource("getPrimesBeginningWithFive")
	public void primeIsOdd(Integer number) {
		assertTrue(isOdd(number));
	}
	
	@RepeatedTest(value=20)
	public void sleep() {
		assertTimeout(Duration.ofMillis(500),
				() -> Thread.sleep(1));
	}
	
	@DisplayName("Good job, now go have a \uD83C\uDF7A")
	@Test
	public void theEnd() {}
	
	
	private static List<Integer> getPrimesBeginningWithFive() {
		return IntStream.iterate(5, i -> i + 1)
				        .filter(i -> isPrime(i))
				        .limit(20)
				        .boxed()
				        .collect(Collectors.toList());
	}
	
	private static boolean isPrime(int number) {
	    return number > 2
	      && IntStream.rangeClosed(2, (int) Math.sqrt(number))
	      .noneMatch(n -> (number % n == 0));
	}
	
	private boolean isOdd(int number) {
		return number % 2 != 0;
	}
}
