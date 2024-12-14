package tests;

import org.testng.annotations.Test;
import pages.JMeterPage;
import pages.RestAssuredPage;

import java.util.HashMap;
import java.util.Map;

public class PerformanceTests {

    private final RestAssuredPage restAssuredPage = new RestAssuredPage();
    private final JMeterPage jMeterPage = new JMeterPage();

    @Test(priority = 1)
    public void apiPerformanceTest() {
        restAssuredPage.setupRestAssured();

        Map<String, String> payload = new HashMap<>();
        payload.put("username", "testuser");
        payload.put("password", "password123");

        var response = restAssuredPage.sendPostRequest("/auth/login", payload);
        System.out.println("API Response: " + response.getBody().asString());
        System.out.println("Response Time: " + response.getTime() + "ms");
    }

    @Test(priority = 2)
    public void jmeterPerformanceTest() {
        jMeterPage.runJMeterTest("src/test/resources/testplan.jmx");
    }
}
