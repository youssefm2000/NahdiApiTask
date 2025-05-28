package utils;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;

/**
 * This utility class provides helper methods for making HTTP requests
 * using Rest Assured. It also loads the base URL from a configuration file.
 */
public class Helper {

    private static String baseUrl;

    // It reads the base URL from the config.properties file.
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

    /**
     * Sends a GET request to the specified endpoint.
     * @return Response object containing the result of the request
     */
    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(baseUrl + endpoint);
    }

    /**
     * Sends a POST request to the specified endpoint with a JSON body.
     * @return Response object containing the result of the request
     */
    public static Response postRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body) // Serialize the object to JSON
                .when()
                .post(baseUrl + endpoint);
    }
}
