package testng_Execution;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjectModel.FileLibClass;

public class Class_01 {
	WebDriver driver;
	@Test
	public void mumbaiIndians() throws InterruptedException
	{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://www.google.com/");
				driver.switchTo().activeElement().sendKeys("mumbai indians" + Keys.ENTER);
				try {
		            // Check if reCAPTCHA iframe exists
		            if (driver.findElements(By.className("recaptcha-checkbox-border")).size() > 0) {
		                System.out.println("reCAPTCHA detected — please verify manually.");
		                driver.switchTo().frame(driver.findElement(By.className("recaptcha-checkbox-border")));
		                System.out.println("Switched to reCAPTCHA iframe.");
		                // Stop automation and allow manual verification
		                Thread.sleep(15000); // give you 15 sec to solve manually
		                driver.switchTo().defaultContent();
		            } else {
		                System.out.println("No reCAPTCHA found, continuing...");
		            }
		        } catch (Exception e) {
		            System.out.println("Unable to handle reCAPTCHA: " + e.getMessage());
		        }
				Thread.sleep(5000);
		}
}
