package pageObjectModel;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recipe_Page {
	
	//Declaration
	@FindBy(css = "input[placeholder='Search for...']") private WebElement searchfield;
	@FindBy(xpath = "//span[normalize-space()='Delete']") private WebElement Deletebutton;
	
	//initialization
	public WebElement getSearchfield() {
		return searchfield;
	}
	public WebElement getDeletebutton() {
		return Deletebutton;
	}
	
	//utilization
	public Recipe_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String enterinsearchfield(String recipename)
	{
		searchfield.sendKeys(recipename);
		searchfield.clear();
		searchfield.sendKeys(recipename);
		return recipename;
	}
}
