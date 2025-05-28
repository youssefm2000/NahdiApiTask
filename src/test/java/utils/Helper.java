package utils;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;

public class Helper {

    private static String baseUrl;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
            baseUrl = properties.getProperty("base.url");
        } catch (IOException e) {
            e.printStackTrace();
            baseUrl = "";
        }
    }

    public static Response getRequest(String endpoint) {
        return given().when().get(baseUrl + endpoint);
    }

    public static Response postRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(baseUrl + endpoint);
    }
}
