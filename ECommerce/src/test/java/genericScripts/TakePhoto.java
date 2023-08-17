package genericScripts;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TakePhoto {
	@Test
	public static void takePhoto(WebDriver driver)
	{
		try {
			Date date = new Date();
			String path = "./photos/" + date.toString().replaceAll(" ", "").replaceAll(":", "-") + ".png";
			File dest = new File(path);
			TakesScreenshot tss = (TakesScreenshot) driver;
			File src = tss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, dest);
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
