package utils;

import io.restassured.RestAssured;

public class BaseUtils {
    protected String baseURL = "https://api.example.com"; // Replace with your API base URL

    public void setupRestAssured() {
        RestAssured.baseURI = baseURL;
    }
}
