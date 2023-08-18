package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericScripts.GenerateUserData;
import genericScripts.HandlingDataFromPropertyFile;

public class LoginPage {
	WebDriver driver;

	@FindBy(css = "div.login-form form input[name='email']")
	private WebElement loginEmailTextField;

	@FindBy(css = "div.login-form form input[name='password']")
	private WebElement loginPasswordTextField;

	@FindBy(xpath = "//button[.='Login']")
	private WebElement loginButton;

	@FindBy(css = "div.signup-form form input[name='name']")
	private WebElement signUpNameTextField;

	@FindBy(css = "div.signup-form form input[name='email']")
	private WebElement signUpEmailTextField;

	@FindBy(xpath = "//button[.='Signup']")
	private WebElement signUpButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterEmailPasswordForLogin() throws Exception {
		String email = HandlingDataFromPropertyFile.getData("./resources/login.properties", "email");
		String password = HandlingDataFromPropertyFile.getData("./resources/login.properties", "password");

		loginEmailTextField.sendKeys(email);
		Thread.sleep(2000);

		loginPasswordTextField.sendKeys(password);
		Thread.sleep(2000);
	}

	public void clickLoginButton() throws Exception {
		loginButton.click();
		Thread.sleep(2000);
	}

	public void enterEmailPasswordForSignUp() throws Exception {
		GenerateUserData.data();
		
		String name = HandlingDataFromPropertyFile.getData("./resources/register.properties", "first_name").concat(HandlingDataFromPropertyFile.getData("./resources/register.properties", "last_name"));
		String email = HandlingDataFromPropertyFile.getData("./resources/register.properties", "email");

		signUpNameTextField.sendKeys(name);
		Thread.sleep(2000);

		signUpEmailTextField.sendKeys(email);
		Thread.sleep(2000);
	}

	public void clickSignUpButton() throws Exception {
		signUpButton.click();
		Thread.sleep(2000);
	}
}
