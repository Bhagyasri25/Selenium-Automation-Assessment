package runners;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefinitions","Hooks"},
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber.html",
	        "json:target/cucumber-reports/cucumber.json"
	    },
	    tags = "@Smoke or @Sanity or @Regression", 
	    monochrome = true
	)
	public class TestRunner extends AbstractTestNGCucumberTests {

	}