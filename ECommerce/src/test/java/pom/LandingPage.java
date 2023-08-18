package pom;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(4) a")
	private WebElement loginLink;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(8) a")
	private WebElement contactUsLink;

	@FindBy(css="ul.nav.navbar-nav li:nth-child(2) a")
	private WebElement productsLink;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickLoginLink() throws Exception
	{
		loginLink.click();
		Thread.sleep(2000);
	}
	
	public void clickContactUsLink() throws Exception
	{
		contactUsLink.click();
		Thread.sleep(2000);
	}
	public void clickProductsLink() throws Exception
	{
		productsLink.click();
		Thread.sleep(2000);
	}
}
