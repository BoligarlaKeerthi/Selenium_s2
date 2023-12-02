package tests;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.MyListener;

import org.testng.Assert;
@Listeners(value= {MyListener.class})
public class LoginTest extends BasePage {
	LoginPage l;

	@Test(dataProvider = "testdata")
	public void test_Login_Page(String Username,String Password , String Status) throws InterruptedException {
		
		l=new LoginPage(driver);

		Thread.sleep(3000);
		l.Login_Details(Username, Password);
		
		Thread.sleep(10000);
	
		//if(Status.equals("pass")) {
			//l.logout_button.click();
			//}	
		try {
			l.logout_button.click();
		}catch(Exception e) {
			Assert.fail("Sign Out is not Present");
		}

	}
	
	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException {

		Object input[][] = ExcelUtility.getTestData("Sheet1");
		return input;

	}
	@BeforeTest() 

	public void openBrowser()

	{ 

	 getbrowser(); 

	  } 
	@AfterTest
	public void closeBrowser() {
		closebrowser();
	}
	
}
	