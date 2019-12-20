package pl.com.tt.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        String result = service.getModeReadable();
        
        fixture.newDefaultValueAfterRefaktor();
        
        assertEquals(fixture.getValue(), result);
    }

    @Test
    public void shouldTestAnotherMode() {
        
        assertThrows(NullPointerException.class, () -> {
           service.getModeReadable2(); 
        });
        
    }

    @Test
    public void shouldCreateCoolingReport(@TempDir File newFolder) throws IOException {
        System.out.println(newFolder.getAbsolutePath());
    }
    
    @Test
    public void shouldCreateCoolingReport2(@TempDir File newFolder) throws IOException {
        System.out.println(newFolder.getAbsolutePath());
    }

    public static class MyFixture {
        private String defaultFacilityValue;
     
        public MyFixture() {
            defaultFacilityValue = "off";
        }
        
        public void newDefaultValueAfterRefaktor() {
            defaultFacilityValue = "normal";
        }
        
        public String getValue() {
            return defaultFacilityValue;
        }

    }

    private MyFixture fixture = new MyFixture();

    @Test
    public void testRule2() throws IOException {
        assertNotNull(fixture);
    }

}
