package pl.com.tt.unittesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;

public class CoolingFacility 
{
    public static enum CoolingMode {
        AUTO, TURBO, NORMAL, OFF
    };
    
    private CoolingMode mode;
    
    public CoolingFacility() {
        this(CoolingMode.OFF);
    }
    
    public CoolingFacility(CoolingMode mode) {
        this.mode = mode;
    }
    
    public CoolingMode getMode() {
        return mode;
    }
    
    public String getModeReadable() {
        return mode.name().toLowerCase();
    }
    
    public void changeMode(CoolingMode mode) {
        this.mode = mode;
    }
    
    public void saveCoolingReport(File folder) throws IOException {
        Path reportPath = folder.toPath().resolve("report.txt");
        File reportFile = reportPath.toFile();
        if(!reportFile.exists()) {
            reportFile.createNewFile();
        }
        try (PrintStream out = new PrintStream(new FileOutputStream(reportFile))) {
            out.print("Facility is working in mode " + mode.name());
        }
    }
}
