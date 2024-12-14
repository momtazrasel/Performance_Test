package pages;

import java.io.File;

public class JMeterPage {

    public void runJMeterTest(String jmxFilePath) {
        File testPlan = new File(jmxFilePath);
        if (!testPlan.exists()) {
            throw new RuntimeException("JMeter test plan file not found: " + jmxFilePath);
        }
        System.out.println("Running JMeter test plan: " + jmxFilePath);
        // Include logic to execute JMeter test plans using CLI or APIs.
    }
}
