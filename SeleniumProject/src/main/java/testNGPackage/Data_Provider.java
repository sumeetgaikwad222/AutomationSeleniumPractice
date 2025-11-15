package testNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {
	WebDriver driver;
	@BeforeMethod
	public void beforeverything()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://aasatech.in1.apiqcloud.com/login?back_url=https%3A%2F%2Faasatech.in1.apiqcloud.com%2F");
		
	}
	//Lets create data provider
	@DataProvider
	public Object[][] dataprovider()
	{
		Object[][] data = new Object[5][2];
		data[0][0] = "admin";
		data[0][1] = "password";
		
		data[1][0] = "admin23";
		data[1][1] = "password";
		
		data[2][0] = "admin";
		data[2][1] = "wrong password";
		
		data[3][0] = "adminwrong";
		data[3][1] = "passworddsgg";
		
		data[4][0] = "sumeet.gaikwad@aasa.tech";
		data[4][1] = "Sumeet@123";
		return data;
	}
	
	
	@Test(dataProvider = "dataprovider")
	public void testinvalidlogin(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
	}
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
	}
}
