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
        String string = service.getModeReadable();
        assertEquals(string, "off");
    }

    @Test
    public void shouldReturnHelloString2() {
        service.changeMode(CoolingMode.TURBO);
        String string = service.getModeReadable();
        assertEquals(string, "turbo");
    }

    @Test
    public void testRule(@TempDir File newFolder) throws IOException {
        service.saveCoolingReport(newFolder);
        File reportFile = newFolder.toPath().resolve("report.txt").toFile();
        assertTrue(reportFile.exists());
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
