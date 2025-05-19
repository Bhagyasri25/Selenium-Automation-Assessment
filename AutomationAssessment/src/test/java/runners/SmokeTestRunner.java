package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = {"stepdefinitions", "Hooks"},
	    tags = "@Smoke",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/smoke.html",
	        "json:target/cucumber-reports/smoke.json"
	    },
	    monochrome = true
	)
public class SmokeTestRunner extends AbstractTestNGCucumberTests {

 
	}
