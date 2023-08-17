package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericScripts.HandlingDataFromPropertyFile;

public class LoginPage {
WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(4) a")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterEmailPassword() throws Exception
	{
		String email = HandlingDataFromPropertyFile.getData("./resources/login.properties", "email");
		String password = HandlingDataFromPropertyFile.getData("./resources/login.properties", "password");
		
		emailTextField.sendKeys(email);
		Thread.sleep(2000);
		
		passwordTextField.sendKeys(password);
		Thread.sleep(2000);
	}
	
	public void clickLoginButton() throws Exception
	{
		loginButton.click();
		Thread.sleep(2000);
	}
}
