package QAFox.ECommerce;

import org.testng.annotations.Test;

import genericScripts.LaunchCloseBrowser;
import pom.HomePage;
import pom.LandingPage;
import pom.LoginPage;
import pom.ProductsPage;
import pom.RegisterPage;

public class AppTest3 extends LaunchCloseBrowser
{
    @Test
    public void testApp() throws Exception
    {
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.clickProductsLink();
    	
    	ProductsPage productsPage = new ProductsPage(driver);
    	productsPage.fetchProductDetails();
    }
}
