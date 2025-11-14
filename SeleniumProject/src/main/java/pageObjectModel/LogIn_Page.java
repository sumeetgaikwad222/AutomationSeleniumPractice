package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page {
	
	//declare all the webelements present on log in page.
	@FindBy(id = "login-form_email") private WebElement username;
	@FindBy(id = "login-form_password") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginbutton;
	@FindBy(css = "a[class='ml-1 text-[#3EBEB3] hover:underline']") private WebElement singuplink;
	@FindBy(xpath = "//a[normalize-space()='Forgot password?']") private WebElement forgotpasswordlink;
	
	//initialization
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getSinguplink() {
		return singuplink;
	}

	public WebElement getForgotpasswordlink() {
		return forgotpasswordlink;
	}
			
	//utilization
	public LogIn_Page(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	//invalid method

	public void validuser(String valiusername, String validpassword) throws InterruptedException
	{
		username.sendKeys(valiusername);
		password.sendKeys(validpassword);
		loginbutton.click();
	}
	public void invaliduser (String valiusername, String validpassword) throws InterruptedException
	{
		username.sendKeys(valiusername);
		password.sendKeys(validpassword);
		loginbutton.click();
		Thread.sleep(3000);
		username.clear();
	}
	
	
}
