package pl.com.tt.unittesting;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OperationTest {

	private static Collection<Integer> sourceData() {
		return Arrays.asList(3, 4, 5);
	}

	private Operation service = new Operation();

	@ParameterizedTest(name = "{0} + 1 = {2}")
	@ValueSource(ints = { 3, 4, 5 })
	void shouldIncrement(int input) {
		int result = service.inc(input);

		Assertions.assertEquals(input + 1, result);
	}

	@ParameterizedTest(name = "{0} + 1 = {2}")
	@MethodSource(value = "sourceData")
	void shouldIncrement2(int input) {
		int result = service.inc(input);

		Assertions.assertEquals(input + 1, result);
	}

	@TestFactory
	Stream<DynamicTest> dynamicTest() {
		return Stream.of(1, 2, 4).map(value -> DynamicTest.dynamicTest("Dynamic " + value, () -> {
			int result = service.inc(value);

			Assertions.assertEquals(value + 1, result);
		}));
	}
}
