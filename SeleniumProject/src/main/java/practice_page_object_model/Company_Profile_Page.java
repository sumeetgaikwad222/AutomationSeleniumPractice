package practice_page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company_Profile_Page {
	//Declaration
	@FindBy(xpath = "//span[normalize-space()='Add Outlet']") private WebElement addoutletbutton;
	@FindBy(xpath = "//span[normalize-space()='Add Outlet']") private WebElement closebutton;
	
	//Initialization 
	public WebElement getAddoutletbutton() {
		return addoutletbutton;
	}
	public WebElement getClosebutton() {
		return closebutton;
	}
	//Utilization 
	public Company_Profile_Page(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	
	public void addoutlet()
	{
		addoutletbutton.click();
		closebutton.click();
	}
	
}
