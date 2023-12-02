package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//a[text()='Log in']")
	public static WebElement login_Link;
	
	@FindBy(xpath="//input[@id='Email']")
	public static WebElement email_id;
	
	@FindBy(xpath="//input[@id='Password']")
	public static WebElement passwords;
	
	@FindBy(xpath="//input[@value='Log in']")
	public static WebElement login_button;
	
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement logout_button;
	
	
	public void Login_Details(String email,String password ) {
		
		login_Link.click();
		email_id.sendKeys(email);
		passwords.sendKeys(password);
		login_button.click();
	}
	
	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
}

