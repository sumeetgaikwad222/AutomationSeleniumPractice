package from_the_scrach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Depend_Class implements IConstant {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty(ChromDriverKey, ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test(dataProvider = "dataprovidefromhere")
	public void dataprovidehere(String username)
	{
		driver.findElement(By.name("q")).sendKeys(username);
		driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']")).click();
	}
	@DataProvider
	public Object[][] dataprovidefromhere()
	{
		return new Object[][] {
            {"Virat Kohli"},
            {"Dhoni"},
            {"Rohit Sharma"}
        };
		
	}
}
