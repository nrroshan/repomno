package QAFox.ECommerce;

import org.testng.annotations.Test;

import genericScripts.LaunchCloseBrowser;
import pom.ContactUsPage;
import pom.HomePage;
import pom.LandingPage;
import pom.LoginPage;
import pom.RegisterPage;

public class AppTest4 extends LaunchCloseBrowser
{
    @Test
    public void testApp() throws Exception
    {
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.clickContactUsLink();
    	
    	ContactUsPage contactUsPage = new ContactUsPage(driver);
    	contactUsPage.fillForm();
    	contactUsPage.verifyFormSubmission();
    }
}
