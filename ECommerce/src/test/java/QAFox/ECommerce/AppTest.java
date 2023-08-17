package QAFox.ECommerce;

import org.testng.annotations.Test;

import genericScripts.LaunchCloseBrowser;
import pom.HomePage;
import pom.LandingPage;
import pom.LoginPage;

public class AppTest extends LaunchCloseBrowser
{
    @Test
    public void testApp() throws Exception
    {
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.clickLoginLink();
    	
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.enterEmailPassword();
    	loginPage.clickLoginButton();
    	
    	HomePage homePage = new HomePage(driver);
    	homePage.clickLogoutLink();
    }
}
