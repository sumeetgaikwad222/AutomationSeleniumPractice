package practice_page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	//Declaration
	@FindBy(xpath = "//input[@placeholder='Search for...']") private WebElement searchfield;
	@FindBy(xpath = "//span[normalize-space()='Apply']") private WebElement applybutton;
	@FindBy(xpath = "//span[contains(text(),'Company Profile')]") private WebElement companytab;
	@FindBy(css = ".lucide.lucide-circle-user-round") private WebElement profileicon;
	@FindBy(css = ".ant-dropdown-menu-title-content") private WebElement logout;
	
	//Initialization
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getcompanytab() {
		return companytab;
	}
	public WebElement getlogout() {
		return logout;
	}public WebElement getApplybutton() {
		return applybutton;
	}
	public WebElement getprofileicon() {
		return profileicon;
	}
	//utilization
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver , this );	
		}
	
	public void enterintextbox() throws InterruptedException
	{
		searchfield.sendKeys("Hot Chocolate");
		applybutton.click();
		Thread.sleep(3000);
		companytab.click();
	}
	public void logout() throws InterruptedException
	{
		profileicon.click();
		Thread.sleep(3000);
		logout.click();
	}
	public void printcheck()
	{
		System.out.println("Sumeet Gaikwad :- this is added from the github to check pull request");
	}
}
