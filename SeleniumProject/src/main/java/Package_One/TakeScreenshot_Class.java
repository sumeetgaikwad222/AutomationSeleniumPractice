package Package_One;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
public class TakeScreenshot_Class {
	private static final String Output = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		   driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       
	       driver.get("https://www.google.com/");
	       driver.findElement(By.name("q"));
	       File F = driver.getScreenshotAs(OutputType.FILE);
	       Files.copy(F, new File("C:\\Users\\SUMEET GAIKWAD\\OneDrive\\Pictures\\Selenium Screenshots\\amazonscreeshot.jpg"));
	       
	       
	       driver.get("https://www.google.com/");
	       driver.findElement(By.name("q")).sendKeys("amazon");
	       Thread.sleep(2000);
	       TakesScreenshot ts = (TakesScreenshot) driver;
	        ts.getScreenshotAs(OutputType.FILE);
	        Files.copy((File) ts, new File("C:\\Users\\SUMEET GAIKWAD\\OneDrive\\Pictures\\Selenium Screenshots\\amazonscreeshot.jpg"));
	       
	}
}
