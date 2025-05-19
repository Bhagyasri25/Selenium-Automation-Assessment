package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefinitions", "Hooks"},
	    tags = "@Regression",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/regression.html",
	        "json:target/cucumber-reports/regression.json"
	    },
	    monochrome = true
	)
	public class RegressionTestRunner extends AbstractTestNGCucumberTests {
	}