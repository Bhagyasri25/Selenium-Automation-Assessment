package stepdefinitions;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.WebElements;
import utils.DriverFactory;
import utils.commonUtilityMethods;

	public class jobSearchSteps {
		public static WebElements element() {
		    return new WebElements(DriverFactory.getDriver());
		}

		public static commonUtilityMethods ele() {
		     return new commonUtilityMethods(DriverFactory.getDriver());
		}

	    @Given("The user initiates the career website")
	    public void launchCareersWebsite() {
	    	 WebDriver driver = DriverFactory.getDriver();
	         driver.get(element().url);
	         ele().waitForSeconds(15);
	         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	         // Waiting for the shadow host
	         WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(
	             By.cssSelector("#usercentrics-root")
	         ));
	         JavascriptExecutor js = (JavascriptExecutor) driver;
	         WebElement acceptBtn = (WebElement) js.executeScript(
	             "return document.querySelector('#usercentrics-root').shadowRoot" +
	             ".querySelector('[data-testid=\"uc-accept-all-button\"]');"
	         );
	         if (acceptBtn != null) {
	             acceptBtn.click();
	             System.out.println("Accept button clicked.");
	         } else {
	             System.out.println("Accept button not found.");
	         }
	    }

	    @Then("Verify that the website loaded successfully")
	    public void validatePageIsDisplayed() {
	    	 WebDriver driver = DriverFactory.getDriver();
	    	 String actualTitle = driver.getTitle();
	         assertThat(actualTitle)
	                 .as("Page title should match expected")
	                 .isEqualTo("Home – Deutsche Bank Careers");	   

	    
	         boolean isLogoDisplayed = element().logo.isDisplayed();
	         assertThat(isLogoDisplayed)
	                 .as("Logo should be visible on homepage")
	                 .isTrue();   
	    }

	    @When("The User navigates to Search Roles")
	     public void navigateToSeachRole() throws InterruptedException{
	    	 WebDriver driver = DriverFactory.getDriver();
	    	 ele().naviagteTillSearchRolePage();
	    	 System.out.println(driver.getTitle());
	    	 
	    	 assertThat(driver.getTitle())
            .as("Page title should match expected")
            .isEqualTo("Search Roles – Deutsche Bank Careers");	
	    	 
	    	 By professionRadioButton = By.xpath("//button[@value='profession']");
	    	 WebElement profRadioButton = ele().scrollHighlightLocator(professionRadioButton, 10);
	    	 profRadioButton.click();
	    	 System.out.println("radio button clicked successfully");
	    	 ele().waitForSeconds(5);
	    	
	    }
	    
	    
	    @Then("Validate that the Dropdowns, KeyWord Search textbox and Search button are visible on the Search Roles page")
	    public void validateUIElements()
	    {
	    	Assert.assertTrue(element().professionalCategory.isDisplayed(), "Profession Category dropdown should be displayed");
	    	Assert.assertTrue(element().city.isDisplayed(), "City dropdown should be displayed");
	    	Assert.assertTrue(WebElements.searchButton.isDisplayed(), "Search button should be displayed");
	    	Assert.assertTrue(element().roleTitle.isDisplayed(), "Role Title Text field should be displayed");
	    	
	    }

	     
	     @When("The user searches the job with single dropdown")
		    public void searchTheJobWithSingleDropDown()
		    {
		    	 element().city.sendKeys("Bangalore" + Keys.ENTER);
		    	 System.out.println("Bangalore clicked successfully");
		    	 ele().waitForSeconds(15);
				 WebElements.searchButton.click();
		    	 ele().waitForSeconds(15);
		    }
	     
	     @Then("The results should contain the city keyword {string}")
		    public void verifyResultsForSingleDropdownFilter(String value)
		    {
	    	 System.out.println(element().citytext.getText());
	    	 assertThat(element().citytext.getText()).contains(value);
	    	 
		    }

	    @When("The user searches the job with multiple dropdown options")
	    public void searchTheJobWithMultiDropDown()
	    {
	    	 element().professionalCategory.sendKeys("Technology" + Keys.ENTER);
	    	 System.out.println("Technology clicked successfully");
	    	 ele().waitForSeconds(15);
	    	 element().profession.sendKeys("Quality Assurance" + Keys.ENTER);
	    	 System.out.println("Quality Assurance clicked successfully");
	    	 ele().waitForSeconds(15);
	    	 element().country.sendKeys("India" + Keys.ENTER);
	    	 System.out.println("India clicked successfully");
	    	 ele().waitForSeconds(15);
	    	 element();
			  WebElements.searchButton.click();
	    	 ele().waitForSeconds(15);
	    }

	    @Then("The results should contain the keyword {string}")
	    public void verifyKeywordQA(String keyword)
	    {
	    	  WebDriver driver = DriverFactory.getDriver();
	    	  List<WebElement> links = driver.findElements(By.xpath("//h2[contains(text(),'QA')]"));
	    	    // Extracting text from each result and converting them into lowercase
	    	  List<String> resultsLink = links.stream()
	    	  .map(e -> e.getText().toLowerCase())
	    	  .collect(Collectors.toList());
	    	    for(String link : resultsLink)
	    	    {
	    	    	System.out.println(link);
	    	    }
	    	    boolean keywordFound = resultsLink.stream().anyMatch(text -> text.contains("qa"));
	    	    if (keywordFound) {
	    	        System.out.println(" At least one result contains 'QA'");
	    	    } else {
	    	        System.out.println("No search results contain 'QA'");
	    	    }
	    	    ele().waitForSeconds(20);
	    }

	    @When("The user navigates to Search the role with keyword search")
	    public void KeywordSearch() throws InterruptedException
	    {
	    	 ele().naviagteTillSearchRolePage();
	    	 By roleKeyword = By.xpath("//input[@id='roleKeyword']");
	    	 ele().scrollHighlightLocator(roleKeyword, 10);
	    	 ele().waitForSeconds(5);
	    }

	    @When("The user searches the job by passing valid keywords {string} to Keyword field")
	    public void searchJobWithKeywordSearch(String keyword)
	    {
	    	element().jobIdSearch.sendKeys(keyword);
	    	ele().waitForSeconds(5);
	    	WebElements.searchButton.click();
	    	ele().waitForSeconds(10);

	    }


	    @Then("The results should contain the keyword that have been passed in Keyword field {string}")
	    public void verifyResults(String keyword)
	    {
	    	  WebDriver driver = DriverFactory.getDriver();
	    	  List<WebElement> links = driver.findElements(By.xpath("//h2[contains(text(),'Full Stack Engineer')]"));
	    	  List<String> resultsLink = links.stream()
	    	  .map(e -> e.getText().toLowerCase())
	    	  .collect(Collectors.toList());
	    	    for(String link : resultsLink)
	    	    {
	    	    	System.out.println(link);
	    	    }
	    	    boolean keywordFound = resultsLink.stream().anyMatch(text -> text.contains("full stack engineer"));
	    	    assertThat(keywordFound)
                .as("Check if the job titles contain keyword: '%s'", keywordFound)
                .isTrue();
	    	    ele().waitForSeconds(20); 
	    }

	    
      @When("The user searches the job by passing Job ID {string} to Keyword field")
      public void searchByValidJobID(String keyword)
      {
           element().jobIdSearch.sendKeys(keyword);
  	       ele().waitForSeconds(5);
  	       WebElements.searchButton.click();
  	       ele().waitForSeconds(10);
	    
      }
	    
	    @Then("The results should contain the Job ID that have been passed in Keyword field {string}")
	    public void validatejobId(String keyword)
	    {
	    	 WebDriver driver = DriverFactory.getDriver();
	    	ele().scrollToElement(By.xpath("//h2[contains(text(),'QA Engineer, AS')]"));
	    	element().validJobIDLink.click();
	    	ele().waitForSeconds(5);
	    	ele().scrollToElement(By.xpath("//h1[contains(text(),'QA Engineer, AS')]"));
	       WebElement jobId = driver.findElement(By.xpath("//div[@id='headerbox']/table/tbody/tr[1]/td[1]"));
	    	assertThat(jobId.getText()).contains(keyword);
	    	
	    	
	    }
	    
	    
	    @Then("Validate when clicked on job link, the user should be navigated to job details page")
	    public void validatejobLink()
	    {
	    	 WebDriver driver = DriverFactory.getDriver();
	    	ele().scrollToElement(By.xpath("//h2[contains(text(),'QA Engineer, AS')]"));
	    	element().validJobIDLink.click();
	    	ele().waitForSeconds(5);
	    	String currentUrl = driver.getCurrentUrl();
	    	System.out.println(currentUrl);
	    	Assert.assertTrue(currentUrl.contains("job"));	      
	    	WebElement jobTitle = driver.findElement(By.xpath("//h1[contains(text(),'QA Engineer, AS')]"));
	    	assertThat(jobTitle.isDisplayed());
	    }
	    
	    
	    @When("The user navigates to Search the role in RoleTitle field")
	    public void RoleTitle() throws InterruptedException
	    {
	    	 ele().naviagteTillSearchRolePage();
	    	 By roleTitle = By.xpath("//input[@id='roleKeyword']");
	    	 ele().scrollHighlightLocator(roleTitle, 10);
	    	 ele().waitForSeconds(5);
	    	
	    	
	    }

	    @When("The user searches the job by passing invalid keywords {string} to role title field")
	    public void searchWithInvalidKeyWords(String keyword)
	    {
	    	element().roleTitle.sendKeys(keyword);
	    	ele().waitForSeconds(5);
	    	//WebElements.search.click();
	    	ele().waitForSeconds(10);

	    }


	    @Then("Verify that a popup is displayed with this message {string}")
	    public void verifyPopup(String keyword)
	    {
	    	System.out.println(element().popUpMsg.getText());
	    	 assertThat(element().popUpMsg.getText())
	    	    .as("Popup message should match expected")
	    	    .isEqualTo(keyword);
	    }
	    
	}



