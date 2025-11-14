package package_package;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Location {
	@FindBy(name = "q") private WebElement field;
	@FindBy(name = "btnK") private WebElement googleSearchbutton;
	@FindBy (name = "btnI") private WebElement Imfeelinggoodbutton;
	@FindBy(xpath = "//a[normalize-space()='About']") private WebElement aboutbutton;
	@FindBy(xpath = "//a[normalize-space()='Store']") private WebElement storebutton;
	
	public WebElement getField() {
		return field;
	}

	public WebElement getGoogleSearchbutton() {
		return googleSearchbutton;
	}

	public WebElement getImfeelinggoodbutton() {
		return Imfeelinggoodbutton;
	}

	public WebElement getAboutbutton() {
		return aboutbutton;
	}

	public WebElement getStorebutton() {
		return storebutton;
	}

	public Location(WebDriver driver) {
        PageFactory.initElements(driver, this);  // ✅ important
    }
	
	public void interact()
	{
		field.sendKeys("Virat Kohli");
	}
}
