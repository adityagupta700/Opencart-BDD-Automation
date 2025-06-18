package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Customers.feature",
		glue = {"stepDefinitions"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/HtmlReports/report.html"}
		//tags = "@sanity"  
		// {"@sanity, @regression"} - this will run either sanity or regression tests
		// {"@sanity", "@regression"} - this will run tests which have both the tags 
		)
public class TestRun {
}
