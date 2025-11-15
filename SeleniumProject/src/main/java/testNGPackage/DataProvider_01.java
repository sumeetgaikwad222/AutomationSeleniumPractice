package testNGPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_01 {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://aasatech.in1.apiqcloud.com/login?back_url=https%3A%2F%2Faasatech.in1.apiqcloud.com%2F");
	}
	//Create dataprovider
	@DataProvider
	public Object[][] dataprovider()
	{
		Object[][] data = new Object[3][2];
		data[0][0] = "admin";
		data[0][1] = "password";
		
		data[1][0] = "Wrong hai";
		data[1][1] = "WrongHai";
		
		data[2][0] = "sumeet.gaikwad@aasa.tech";
		data[2][1] = "Sumeet@123";
		return data;
		
	}
	
	@Test(dataProvider = "dataprovider")
	public void gettingdata(String username, String password)
	{
		driver.findElement(By.cssSelector("#username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-submit")).click();
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
}
