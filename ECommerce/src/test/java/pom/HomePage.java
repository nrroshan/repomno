package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(4) a")
	private WebElement logoutLink;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(5) a")
	private WebElement deleteAccountLink;
	
	@FindBy(css="div.row div h2.title.text-center b")
	private WebElement deleteAccountText;
	
	@FindBy(xpath = "//a[.='Continue']")
	private WebElement continueButton1;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyLogin()
	{
		Assert.assertTrue(deleteAccountLink.isDisplayed());
	}
	
	public void clickLogoutLink() throws Exception
	{
		logoutLink.click();
		Thread.sleep(2000);
	}
	
	public void deleteAccount() throws Exception
	{
		deleteAccountLink.click();
		Thread.sleep(2000);
	}
	
	public void verifyAccountDeleted() throws Exception {
		Assert.assertEquals(deleteAccountText.getText(), "ACCOUNT DELETED!");
		Thread.sleep(2000);
		
		continueButton1.click();
	}
}
