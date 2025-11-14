package testng_Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class_02 {
	WebDriver driver;

	@Test
	public void Roya_Challengers_Banglore() throws InterruptedException {
	    System.setProperty("webdriver.edge.driver","C:\\Users\\SUMEET GAIKWAD\\Drivers\\edgedriver_win64\\edgedriver_win64\\msedge.exe");
	   driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	    driver.switchTo().activeElement().sendKeys("Royal Challengers Banglore" + Keys.ENTER);
	    Thread.sleep(5000);
	    driver.quit();
	}
}
