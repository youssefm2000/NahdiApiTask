package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    @Before
    public void setup() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        RestAssured.baseURI = props.getProperty("base.url");
    }
}
