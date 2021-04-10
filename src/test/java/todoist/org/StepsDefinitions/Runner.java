package todoist.org.StepsDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:build/cucumber/cucumber-report.html",
                "json:build/cucumber/cucumber-report.json", "rerun:build/cucumber/rerun.txt"},
        glue = {"todoist.org"},
        features = {"src/test/resources/features"}, tags = "@Login")

public class Runner extends AbstractTestNGCucumberTests {

}
