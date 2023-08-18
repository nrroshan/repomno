package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import genericScripts.HandlingDataFromPropertyFile;
import genericScripts.ScrollToElement;

public class ContactUsPage {
	WebDriver driver;

	@FindBy(name = "name")
	private WebElement nameTextField;
	
	@FindBy(name = "email")
	private WebElement emailTextField;
	
	@FindBy(name = "subject")
	private WebElement subjectTextField;
	
	@FindBy(name = "message")
	private WebElement messageTextArea;
	
	@FindBy(name = "submit")
	private WebElement submitButton;
	
	@FindBy(css = "div.status.alert.alert-success")
	private WebElement formSubmittedSuccessMessage;
	
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void fillForm() throws Exception
	{
		nameTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "first_name"));
		Thread.sleep(1000);
		
		emailTextField.sendKeys(HandlingDataFromPropertyFile.getData("./resources/register.properties", "email"));
		Thread.sleep(1000);
		
		subjectTextField.sendKeys("Product Delivery");
		Thread.sleep(1000);
		
		messageTextArea.sendKeys("My product has not yet been delivered");
		Thread.sleep(1000);
		
		ScrollToElement.scrollToElement(driver, submitButton);
		Thread.sleep(1000);
		
		submitButton.click();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void verifyFormSubmission() throws Exception
	{
		Assert.assertTrue(formSubmittedSuccessMessage.isDisplayed());
		Thread.sleep(1000);
	}
}
