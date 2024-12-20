package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/CreateAccount.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class AccountRunner extends AbstractTestNGCucumberTests {
}
