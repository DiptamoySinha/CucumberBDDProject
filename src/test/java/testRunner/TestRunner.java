package testRunner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"F:\\CucumberProject\\Features\\Customer.feature"},
        glue = "StepDefinition",
        plugin = {"pretty", "html:reports/report1.html"},
        monochrome = true,
        dryRun = false,
        tags = "@Smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
