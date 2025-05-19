package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefinitions", "Hooks"},
	    tags = "@Sanity",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/sanity.html",
	        "json:target/cucumber-reports/sanity.json"
	    },
	    monochrome = true
	)
	public class SanityTestRunner extends AbstractTestNGCucumberTests {
	}