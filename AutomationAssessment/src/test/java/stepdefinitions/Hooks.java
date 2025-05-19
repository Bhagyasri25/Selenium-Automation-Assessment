package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

	@Before
	public void setUp() {
		System.out.println(">>> [HOOK] Initializing Driver");
	    if (DriverFactory.getDriver() == null) {
	    	 System.out.println("Setup called for thread: " + Thread.currentThread().getId());
	        DriverFactory.initDriver("chrome");
	    }
	}

	@After
	public void tearDown() {
	    DriverFactory.quitDriver();
	}
}
