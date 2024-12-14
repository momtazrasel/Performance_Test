package pages;

import io.restassured.response.Response;
import utils.BaseUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPage extends BaseUtils {

    public Response sendPostRequest(String endpoint, Map<String, String> payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
