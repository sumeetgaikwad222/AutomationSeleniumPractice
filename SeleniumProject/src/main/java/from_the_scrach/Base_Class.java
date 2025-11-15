package from_the_scrach;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class implements IConstant{
	static WebDriver driver;
	public void lauch()
	{
		System.setProperty(ChromDriverKey, ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	public void teardown() throws InterruptedException
	{
		Thread.sleep(10);
		driver.quit();
	}
}
