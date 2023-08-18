package pom;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import genericScripts.HandlingDataFromPropertyFile;

public class RegisterPage {
	WebDriver driver;

	@FindBy(id = "id_gender2")
	private WebElement genderRadioButton;

	@FindBy(id = "name")
	private WebElement nameTextField;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(id = "days")
	private WebElement dayDropdown;

	@FindBy(id = "months")
	private WebElement monthDropdown;

	@FindBy(id = "years")
	private WebElement yearDropdown;

	@FindBy(id = "first_name")
	private WebElement firstNameTextField;

	@FindBy(id = "last_name")
	private WebElement lastNameTextField;

	@FindBy(id = "company")
	private WebElement companyTextField;

	@FindBy(id = "address1")
	private WebElement address1TextField;

	@FindBy(id = "address2")
	private WebElement address2TextField;

	@FindBy(id = "country")
	private WebElement countryDropdown;

	@FindBy(id = "state")
	private WebElement stateTextField;

	@FindBy(id = "city")
	private WebElement cityTextField;

	@FindBy(id = "zipcode")
	private WebElement zipcodeTextField;

	@FindBy(id = "mobile_number")
	private WebElement mobileNumberTextField;
	
	@FindBy(xpath = "//button[.='Create Account']")
	private WebElement createAccountButton;
	
	@FindBy(css = "div.row div h2.title.text-center b")
	private WebElement accountCreatedText;
	
	@FindBy(xpath = "//a[.='Continue']")
	private List<WebElement> continueButton;
	
	@FindBy(xpath = "//a[.='Continue']")
	private WebElement continueButton1;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(4) a")
	private WebElement logoutLink;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterUserDetails() throws Exception {
		genderRadioButton.click();
		Thread.sleep(1000);
		
//		nameTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "first_name").concat(HandlingDataFromPropertyFile.getData("./resources/register.properties", "last_name")));
//		Thread.sleep(1000);
		
//		emailTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "email"));
//		Thread.sleep(1000);
		
		passwordTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "password"));
		Thread.sleep(1000);
		
		Select daySelect = new Select(dayDropdown);
		daySelect.selectByVisibleText(HandlingDataFromPropertyFile.getData("./resources/register.properties", "dd"));
		Thread.sleep(1000);
		
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(HandlingDataFromPropertyFile.getData("./resources/register.properties", "mm"));
		Thread.sleep(1000);
		
		Select yearSelect = new Select(yearDropdown);
		yearSelect.selectByVisibleText(HandlingDataFromPropertyFile.getData("./resources/register.properties", "yyyy"));
		Thread.sleep(1000);
		
		firstNameTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "first_name"));
		Thread.sleep(1000);
		
		lastNameTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "last_name"));
		Thread.sleep(1000);
		
		companyTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "company"));
		Thread.sleep(1000);
		
		address1TextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "address1"));
		Thread.sleep(1000);
		
		address2TextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "address2"));
		Thread.sleep(1000);
		
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText(HandlingDataFromPropertyFile.getData("./resources/register.properties", "country"));
		Thread.sleep(1000);
		
		stateTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "state"));
		Thread.sleep(1000);
		
		cityTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "city"));
		Thread.sleep(1000);
		
		zipcodeTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "zipcode"));
		Thread.sleep(1000);
		
		mobileNumberTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "mobile"));
		Thread.sleep(1000);
		
		createAccountButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyAccountCreatedAndLogout() throws Exception {
		Assert.assertEquals(accountCreatedText.getText(), "ACCOUNT CREATED!");
		Thread.sleep(2000);
		
		Assert.assertNotEquals(continueButton.size(), 0);
		continueButton1.click();
		
		logoutLink.click();
		Thread.sleep(2000);
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
    	map.put("email", HandlingDataFromPropertyFile.getData("./resources/register.properties", "email"));
    	map.put("password", HandlingDataFromPropertyFile.getData("./resources/register.properties", "password"));
    	HandlingDataFromPropertyFile.setData("./resources/login.properties", map);
	}
}
