package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/Login.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class LoginRunner extends AbstractTestNGCucumberTests {

}
