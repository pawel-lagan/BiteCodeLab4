package pl.com.tt.mocking;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import info.solidsoft.mockito.java8.api.WithBDDMockito;

@ExtendWith(MockitoExtension.class)
public class CarTest implements WithAssertions, WithBDDMockito {

	@Test
	void shouldBeReadyToStart() {
		fail("not implemented");
	}

	@Test
	void shouldNotBeReadyToStartWhenEngineErrors() {
		fail("not implemented");
	}

	@Test
	void shouldNotBeReadyToNoFuelDetected() {
		fail("not implemented");
	}

	@Test
	void carShouldStartWhenAllComponentsOk() {
		fail("not implemented");
	}

	@Test
	void fuelPumpShouldStartBeforeEngine() {
		fail("not implemented");
	}

	@Test
	void shouldNotStartWhenSomethingIsWrong() {
		fail("not implemented");
	}

	@Test
	void shouldPassStartCodeToCheckBeforeStart() {
		fail("not implemented");
	}

	@Test
	void checkShouldPassWhenOilTemperatureIsBelow100() {
		fail("not implemented");
	}

	@Test
	void isWorkingCorrectlyShouldFailWhenOilTemperatureIsAbove100() {
		fail("not implemented");
	}

	@Test
	void isWorkingCorrectlyShouldFailWhenOilPressureIsAbove1000() {
		fail("not implemented");
	}
}
