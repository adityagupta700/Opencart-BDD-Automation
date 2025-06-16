package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Customers.feature",
		glue = {"stepDefinitions"},
		dryRun = true,
		monochrome = true,
		plugin = {"pretty", "html:target/HtmlReports/report.html"}
		)
public class TestRun {
}
