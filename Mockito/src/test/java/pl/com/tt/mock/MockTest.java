package pl.com.tt.mock;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import pl.com.tt.mocking.Engine;

public class MockTest implements WithAssertions {

	private static final long EXPECTED_100L = 100L;

	@Test
	void shouldMockValueByProxy() throws IllegalAccessException, InstantiationException, NoSuchMethodException, SecurityException {
		Engine mock = Mock.mock(Engine.class);
		Mock.when(mock.getOilPressure()).thenReturn(EXPECTED_100L);
		assertThat(mock.getOilPressure()).isEqualTo(EXPECTED_100L);
	}

	@Test
	void shouldMockValueByByteBuddy() throws IllegalAccessException, InstantiationException, NoSuchMethodException, SecurityException {
		Object mock = Mock.mock(Object.class);
		Mock.when(mock.toString()).thenReturn("Super car");
		assertThat(mock.toString()).isEqualTo("Super car");
	}
}
