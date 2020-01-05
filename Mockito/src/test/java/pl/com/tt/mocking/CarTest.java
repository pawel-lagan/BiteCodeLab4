package pl.com.tt.mocking;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import pl.com.tt.mocking.Engine.EngineError;

@ExtendWith(MockitoExtension.class)
public class CarTest implements WithAssertions, WithBDDMockito {

	@Mock
	private Engine engine;

	@Mock
	private FuelPump fuelPump;

	@InjectMocks
	private Car car;

	@Test
	void shouldBeReadyToStart() {
		engineReadyToStart();

		boolean result = car.checkBeforeStart(200L);
		assertThat(result).isTrue();
	}

	private void engineReadyToStart() {
		when(fuelPump.isOn()).thenReturn(true);
		when(fuelPump.isFuelDetected()).thenReturn(true);
		when(fuelPump.isSystemError()).thenReturn(false);
		when(engine.isPowerOn()).thenReturn(true);
		when(engine.isRunning()).thenReturn(false);
		when(engine.getErrors()).thenReturn(Sets.newHashSet());
	}

	@Test
	void shouldNotBeReadyToStartWhenEngineErrors() {
		engineReadyToStart();
		when(engine.getErrors()).thenReturn(Sets.newTreeSet(EngineError.INJECTOR_ERROR));

		boolean result = car.checkBeforeStart(200L);
		assertThat(result).isFalse();
	}

	@Test
	void shouldNotBeReadyToNoFuelDetected() {
		engineReadyToStart();
		when(fuelPump.isFuelDetected()).thenReturn(false);

		boolean result = car.checkBeforeStart(200L);
		assertThat(result).isFalse();
	}

	@Test
	void carShouldStartWhenAllComponentsOk() {
		Car spy = spy(car);

		doReturn(true).when(spy).checkBeforeStart(any());

		spy.start(200L);

		verify(fuelPump, times(1)).start();
		verify(engine, times(1)).start();
	}

	@Test
	void fuelPumpShouldStartBeforeEngine() {
		Car spy = spy(car);

		doReturn(true).when(spy).checkBeforeStart(any());

		spy.start(200L);

		InOrder order = inOrder(fuelPump, engine);

		order.verify(fuelPump, times(1)).start();
		order.verify(engine, times(1)).start();
	}

	@Test
	void shouldNotStartWhenSomethingIsWrong() {
		Car spy = spy(car);

		doReturn(false).when(spy).checkBeforeStart(any());

		spy.start(200L);

		verify(fuelPump, times(0)).start();
		verify(engine, times(0)).start();
	}

	@Test
	void shouldPassStartCodeToCheckBeforeStart() {
		Car spy = spy(car);

		ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);

		doReturn(false).when(spy).checkBeforeStart(captor.capture());

		spy.start(200L);

		assertThat(captor.getValue()).isEqualTo(200L);
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
		// fail("not implemented");
	}
}
