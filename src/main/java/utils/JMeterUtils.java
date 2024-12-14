package utils;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;

import java.io.File;

public class JMeterUtils {

    public void configureJMeter(String jmeterHomePath) {
        // Construct the JMeter properties path
        String jmeterPropertiesPath = jmeterHomePath + "/bin/jmeter.properties";
        File propertiesFile = new File(jmeterPropertiesPath);

        if (!propertiesFile.exists()) {
            throw new IllegalArgumentException("JMeter properties file not found at: " + jmeterPropertiesPath);
        }

        // Set JMeter home as a system property (for JMeter internal use)
        System.setProperty("jmeter.home", jmeterHomePath);

        // Load JMeter properties
        JMeterUtils.loadJMeterProperties(propertiesFile.getPath());

        // Initialize logging and locale
        JMeterUtils.initLogging(); // Optional
        JMeterUtils.initLocale();  // Set default locale
    }

    public StandardJMeterEngine createJMeterEngine(HashTree testPlanTree) {
        StandardJMeterEngine jmeterEngine = new StandardJMeterEngine();
        jmeterEngine.configure(testPlanTree);
        return jmeterEngine;
    }

    public ThreadGroup createThreadGroup(int users, int rampUpTime, int duration) {
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setNumThreads(users);
        threadGroup.setRampUp(rampUpTime);
        threadGroup.setScheduler(true);
        threadGroup.setDuration(duration);
        return threadGroup;
    }
}
