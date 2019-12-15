package pl.com.tt.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import pl.com.tt.unittesting.CoolingFacility.CoolingMode;

public class CoolingFacilityTest {

    public CoolingFacility service = new CoolingFacility();

    @Test
    @DisplayName("Should return default mode name in human readable form")
    public void shouldReturnDefaultModeName() {
    }

    @Test
    public void shouldTestAnotherMode() {
    }

    @Test
    public void shouldCreateCoolingReport(@TempDir File newFolder) throws IOException {
    }

    public static class MyFixture {

    }

    private MyFixture fixture = new MyFixture();

    @Test
    @Disabled("for now")
    public void testRule2() throws IOException {
        assertNotNull(fixture);
    }

}
