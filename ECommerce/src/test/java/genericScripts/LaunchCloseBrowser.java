package genericScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LaunchCloseBrowser implements FrameworkConstants
{
	String browser;
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		browser = HandlingDataFromPropertyFile.getData("./resources/website.properties", "browser");
		String url = HandlingDataFromPropertyFile.getData("./resources/website.properties", "url");
		
		if(browser.equals("chrome"))
		{
			System.setProperty(chrome_key, chrome_value);
			
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("firefox"))
		{
			System.setProperty(firefox_key, firefox_value);
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
