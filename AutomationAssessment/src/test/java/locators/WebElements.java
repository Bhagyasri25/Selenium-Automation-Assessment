package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements {
	public WebElements(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public String url = "https://careers.db.com/";

	
//	@FindBy(xpath = "//a[contains(text(),'Professionals')]")
//	public WebElement hoverProfessional;

	@FindBy(xpath = "//a[@title='Deutsche Bank Logo']")
	public WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(),'Search Roles')]")
	public WebElement SearchRoles;

	@FindBy(xpath = "//button[@value='profession']")
	public WebElement professionRadioButton;

	@FindBy(xpath = "(//input[@placeholder='Please select'])[1]")
	public WebElement professionalCategory;

	@FindBy(xpath = "(//input[@placeholder='Please select'])[1]")
	public WebElement profession;

	@FindBy(xpath = "(//input[@placeholder='Please select'])[1]")
	public WebElement country;
	
	@FindBy(xpath = "(//input[@placeholder='Please select'])[5]")
	public WebElement city;
	
	@FindBy(xpath = "//div[@class='detail-entry']")
	public WebElement citytext;
	
	
	@FindBy(xpath = "(//a[contains(text(),' Search ')])[3]")
	public static WebElement searchButton;

	@FindBy(xpath = "//input[@id='jobIdSearch']")
	public WebElement jobIdSearch;
	
	@FindBy(xpath = "//input[@id='roleKeyword']")
	public WebElement roleTitle;
	
	@FindBy(xpath = "//h2[contains(text(),'QA Engineer, AS')]")
	public WebElement validJobIDLink;
	
	
@FindBy(xpath = "//ul[@id='menu']//li[normalize-space(text())='Sorry, no matching options']\n"
		+ "")
	public WebElement popUpMsg;




}
