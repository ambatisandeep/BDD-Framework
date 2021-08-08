package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"StepDefinitions","Hooks"},
        tags="@sanity",
        monochrome = true,
        plugin = {"pretty","html:test-output"})

public class TestRunner {


}
