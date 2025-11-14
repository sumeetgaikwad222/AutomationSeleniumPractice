package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	//Declaration.
	@FindBy (xpath = "//span[contains(text(),'Recipes')]") private WebElement recipetab;
	@FindBy(xpath = "//span[contains(text(),'Company Profile')]") private WebElement companprofilelink;
	@FindBy(css = ".lucide.lucide-circle-user-round") private WebElement profileicon;
	@FindBy(xpath = "//span[@class='ant-dropdown-menu-title-content']") private WebElement logoutbutton;
	
	//initialization
	public WebElement getRecipetab() {
		return recipetab;
	}
	public WebElement getCompanprofilelink() {
		return companprofilelink;
	}
	public WebElement getProfileicon() {
		return profileicon;
	}
	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
	
	//Utilization
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void logout() throws InterruptedException
	{
		profileicon.click();
		Thread.sleep(5000);
		logoutbutton.click();
	}
}
