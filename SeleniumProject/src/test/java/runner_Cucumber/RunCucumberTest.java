package runner_Cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Login.feature",
    glue = "stepDefinitions_Cucumber",
    plugin = {"pretty", "html:target/cucumber-report.html"},
    monochrome = true
   
)
public class RunCucumberTest {
}
