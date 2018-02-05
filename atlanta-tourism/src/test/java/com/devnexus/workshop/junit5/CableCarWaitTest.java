package com.devnexus.workshop.junit5;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.time.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

import com.devnexus.workshop.junit5.CableCarSchedule;
import com.devnexus.workshop.junit5.CableCarWait;

@RunWith(MockitoJUnitRunner.class)
public class CableCarWaitTest {

	@Mock
	CableCarSchedule mockSchedule;

	CableCarWait target;

	@Before
	public void setUp() {
		target = new CableCarWait(mockSchedule);
	}

	@Test
	public void plentyOfTime() {
		LocalTime noon = LocalTime.of(12, 0);
		LocalTime halfHourEarlier = LocalTime.of(11, 30);
		when(mockSchedule.nextCar()).thenReturn(noon);
		assertTrue(target.timeForHotDog(halfHourEarlier));
	}
	
	@Test
	public void anyMinuteNow() {
		LocalTime noon = LocalTime.of(12, 0);
		LocalTime justEarlier = LocalTime.of(11, 59);
		when(mockSchedule.nextCar()).thenReturn(noon);
		assertFalse(target.timeForHotDog(justEarlier));
	}
	
	@Test
	public void barelyEnoughTime() {
		LocalTime noon = LocalTime.of(12, 0);
		LocalTime fifteenMinutesEarlier = LocalTime.of(11, 45);
		when(mockSchedule.nextCar()).thenReturn(noon);
		assertFalse(target.timeForHotDog(fifteenMinutesEarlier));
	}

}
