package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class commonUtilityMethods {
	private WebDriver driver;
	private WebDriverWait wait;

	    // Constructor to initialize WebDriver
	    public commonUtilityMethods(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize web elements
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default wait time
	    }

	    // Wait for an element to be visible
	    public WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
	        wait.withTimeout(Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    public void waitForSeconds(long seconds) {
	        wait.withTimeout(Duration.ofSeconds(seconds))
	            .until(driver -> true);
	    }

	    // Scroll to the element
	    public void scrollToElement(By locator) {
	        WebElement element = driver.findElement(locator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
	    }

	    
	    public void highlightElement(By locator) {
	        WebElement element = driver.findElement(locator);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].style.border='2px solid red'", element);
	    }

	    // Scroll to and highlight an element
	    public WebElement scrollHighlightLocator(By locator, int timeoutInSeconds) {
	        scrollToElement(locator);
	        WebElement element = waitForElementVisible(locator, timeoutInSeconds);
	        highlightElement(locator);
	        return element;
	    }


       public void naviagteTillSearchRolePage() throws InterruptedException
       {
    	   WebDriver driver = DriverFactory.getDriver();
	    	 WebElement hoverProfessional =	waitForElementVisible(By.xpath("//a[contains(text(),'Professionals')]"), 10);
	    	 Actions actions = new Actions(driver);
	    	 actions.moveToElement(hoverProfessional).build().perform();
	    	 WebElement SearchRoles =waitForElementVisible(By.xpath("//a[contains(text(),'Search Roles')]"), 10);
	    	 SearchRoles.click();
	    	 Thread.sleep(10);
       }

}

//	public static void scrollToAnElement(WebElement element) {
//		((JavascriptExecutor) DriverFactory.initDriver("chrome")).executeScript("arguments[0].scrollIntoView(true);",
//
//	}







