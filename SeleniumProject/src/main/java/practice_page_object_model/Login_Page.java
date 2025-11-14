package practice_page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	//Declaration
	@FindBy(css = "#login-form_email") private WebElement email;
	 @FindBy(id = "login-form_password") 
	    private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement submitbutton;
	
	//initialization 
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	//Utilization
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void validcreads(String username, String password1)
	{
		email.sendKeys(username);
		password.sendKeys(password1);
		submitbutton.click();
		
	}
}
