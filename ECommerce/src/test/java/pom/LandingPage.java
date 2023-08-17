package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	@FindBy(css="ul.nav.navbar-nav li:nth-child(4) a")
	private WebElement loginLink;

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickLoginLink() throws Exception
	{
		loginLink.click();
		Thread.sleep(2000);
	}
}
