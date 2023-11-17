package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        dryRun = false,
        glue = "StepDefinitions",
        tags = "@Add",
        monochrome = true,
        plugin = {"pretty",
                "html:target/report",
                "json:target/report.json",
                "junit:target/report.unit-report.xml"
        }


)
public class RunnerClass {
}
