package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@SuppressWarnings("ALL")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features/TestBank.feature",
        plugin = { "json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports" }
)
public class RunCusBank {
}
