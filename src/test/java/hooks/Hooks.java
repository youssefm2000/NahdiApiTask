package hooks;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    /**
     * This method is executed before each Cucumber scenario.
     * It loads configuration properties from the "config.properties" file,
     * and sets the base URI for all REST Assured API requests using the "base.url" property.
     */

    @Before
    public void setup() throws IOException {

        // Create a Properties object to hold configuration values
        Properties props = new Properties();

        // Load the properties file from the project root directory
        props.load(new FileInputStream("config.properties"));

        // Set the base URI for REST Assured using the value from the properties file
        RestAssured.baseURI = props.getProperty("base.url");
    }
}
