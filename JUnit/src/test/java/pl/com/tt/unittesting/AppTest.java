package pl.com.tt.unittesting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class AppTest {
	public App app = new App();

	@Test
	@DisplayName("Single test successful")
	public void shouldReturnHelloString() {
	}

	@Test
	public void shouldReturnHelloString2() {
	}

	@Test
	public void testRule(@TempDir File newFolder) throws IOException {
		assertTrue(newFolder.exists());
	}

	public static class MyFixture {

	}

	private MyFixture fixture = new MyFixture();

	@Test
	@Disabled
	public void testRule2() throws IOException {
		assertNotNull(fixture);
	}

}
