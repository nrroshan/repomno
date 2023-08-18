package pom;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	@FindBy(css="div.productinfo.text-center p")
	private List<WebElement> productsText;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void fetchProductDetails() throws Exception
	{
		File file = new File("./files/products.txt");
		if(!file.exists())
			file.createNewFile();
		
//		FileWriter fw = new FileWriter(file);
		
		PrintWriter pw = new PrintWriter(file);
		

		for (WebElement products : productsText) {
//			fw.write(products.getText());
			pw.println(products.getText());
			System.out.println(products.getText());
		}
		
//		fw.close();
		pw.close();
		Thread.sleep(2000);
	}
}
