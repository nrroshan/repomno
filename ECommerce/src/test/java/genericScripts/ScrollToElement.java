package genericScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	public static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy("+x+", "+y+")");
	}
}
