package from_the_scrach;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locator_page {

	@FindBy(name = "q")private WebElement searchInput;
	@FindBy(css = "div[class='FPdoLc lJ9FBc'] input[name='btnK']") private WebElement searchbutton;

	
	public WebElement getSearchInput() {
		return searchInput;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public Locator_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void openfield()
	{
		searchInput.sendKeys("Virat Kohli");
		searchbutton.click();
	}
}
