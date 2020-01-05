package pl.com.tt.mocking;

public class Car {
	private final Engine engine;
	private final FuelPump fuelPump;

	public Car(Engine engine, FuelPump fuelPump) {
		super();
		this.engine = engine;
		this.fuelPump = fuelPump;
	}

	boolean checkBeforeStart(Long startCode) {
		boolean componentsOk = fuelPump.isFuelDetected();
		componentsOk &= fuelPump.isOn();
		componentsOk &= !fuelPump.isSystemError();
		componentsOk &= !fuelPump.isRunning();
		componentsOk &= engine.isPowerOn();
		componentsOk &= !engine.isRunning();
		componentsOk &= engine.getErrors().isEmpty();
		componentsOk &= 200L == startCode;
		return componentsOk;
	}

	boolean isWorkingCorrectly() {
		boolean componentsOk = fuelPump.isOn();
		componentsOk &= !fuelPump.isSystemError();
		componentsOk &= fuelPump.isRunning();
		componentsOk &= engine.isRunning();
		componentsOk &= engine.getErrors().isEmpty();
		componentsOk &= engine.getOilTemperature().longValue() <= 100L;
		componentsOk &= engine.getOilTemperature().longValue() > -30L;
		componentsOk &= engine.getOilPressure().longValue() <= 1000L;
		componentsOk &= engine.getOilPressure().longValue() > 500L;

		return componentsOk;
	}

	public void start(Long startCode) {
		if (checkBeforeStart(startCode)) {
			fuelPump.start();
			engine.start();
		}
	}

	public void stop() {
		fuelPump.stop();
		engine.stop();
	}
}
