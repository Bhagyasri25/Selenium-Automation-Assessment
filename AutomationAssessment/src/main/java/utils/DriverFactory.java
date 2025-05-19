package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static WebDriver initDriver(String browser) {
	    if (browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver()
	            .clearDriverCache()
	            .clearResolutionCache()
	            .setup();
	        if (getDriver() == null) {
	            driver.set(new ChromeDriver());
	        }
	        System.out.println("Launching browser on thread: " + Thread.currentThread());
	    } else if (browser.equalsIgnoreCase("ie")) {
	        WebDriverManager.iedriver().setup();
	        driver.set(new InternetExplorerDriver());
	    } else {
	        throw new IllegalArgumentException("Unsupported browser: " + browser);
	    }

	    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    getDriver().manage().window().maximize();
	    return getDriver();
	}


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}