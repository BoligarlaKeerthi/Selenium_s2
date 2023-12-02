package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public static WebDriver driver;
	
	public static void getbrowser()
	{
		  driver = new ChromeDriver();
		 driver.get("http://demowebshop.tricentis.com/");
	}
	public static void closebrowser() {
		driver.close();
	}
	

}

