package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        // Path to the feature files
        features = "src/test/resources/features",
        glue = "steps",

        // Plugins for test output: "pretty" for readable console output,
        // and "html" to generate an HTML report at the specified location
        plugin = {
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "pretty", "html:target/cucumber-report.html"},

        // Ensures cleaner console output by removing unnecessary characters
        monochrome = true
)
public class TestRunner {
}
