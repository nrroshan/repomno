package QAFox.ECommerce;

import org.testng.annotations.Test;

import genericScripts.LaunchCloseBrowser;
import pom.HomePage;
import pom.LandingPage;
import pom.LoginPage;
import pom.RegisterPage;

public class AppTest2 extends LaunchCloseBrowser
{
    @Test
    public void testApp() throws Exception
    {
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.clickLoginLink();
    	
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.enterEmailPasswordForSignUp();
    	loginPage.clickSignUpButton();
    	
    	RegisterPage registerPage = new RegisterPage(driver);
    	registerPage.enterUserDetails();
    	registerPage.verifyAccountCreatedAndLogout();
    	
    	loginPage = new LoginPage(driver);
    	loginPage.enterEmailPasswordForLogin();
    	loginPage.clickLoginButton();
    	
    	HomePage homePage = new HomePage(driver);
    	homePage.verifyLogin();
    	homePage.deleteAccount();
    	homePage.verifyAccountDeleted();
    }
}
