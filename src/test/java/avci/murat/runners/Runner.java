package avci.murat.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml",
        },
        features ="src/test/resources/features",
        glue="avci/murat/step_definitions",
        dryRun = false,
        tags = "@Turkiye"
)

public class Runner {
}
