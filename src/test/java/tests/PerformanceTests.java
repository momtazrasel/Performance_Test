package tests;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jorphan.collections.HashTree;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;
import utils.JMeterUtils;

public class PerformanceTests {

    private JMeterUtils jMeterUtils;
    private LoginPage loginPage;
    private UserPage userPage;
    private String token;

    @BeforeTest
    public void setup() {
        // Initialize utilities and page objects
        jMeterUtils = new JMeterUtils();
        loginPage = new LoginPage();
        userPage = new UserPage();

        // Set JMeter home (update with your JMeter installation path)
        String jmeterHomePath = System.getenv("JMETER_HOME");
        if (jmeterHomePath == null || jmeterHomePath.isEmpty()) {
            throw new RuntimeException("Please set the JMETER_HOME environment variable.");
        }

        jMeterUtils.configureJMeter(jmeterHomePath);
    }

    @Test(priority = 1)
    public void loginPerformanceTest() {
        // Create JMeter Test Plan for Login
        HashTree testPlanTree = new HashTree();
        testPlanTree.add(loginPage.createLoginSampler("testuser", "password123"));

        // Run the test
        StandardJMeterEngine engine = jMeterUtils.createJMeterEngine(testPlanTree);
        engine.run();

        // Simulate parsing response (replace this with actual parsing)
        String jsonResponse = "{ \"accessToken\": \"fakeToken123\" }"; // Replace with response from JMeter
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        token = jsonObject.get("accessToken").getAsString();
    }

    @Test(priority = 2, dependsOnMethods = {"loginPerformanceTest"})
    public void createUserPerformanceTest() {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("Access token not retrieved from login test.");
        }

        // Prepare user data
        String userData = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";

        // Create JMeter Test Plan for User Creation
        HashTree testPlanTree = new HashTree();
        testPlanTree.add(userPage.createUserSampler(token, userData));

        // Run the test
        StandardJMeterEngine engine = jMeterUtils.createJMeterEngine(testPlanTree);
        engine.run();
    }
}
