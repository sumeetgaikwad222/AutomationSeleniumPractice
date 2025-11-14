package generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasaClass {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://aasatech.in1.apiqcloud.com/login?back_url=https%3A%2F%2Faasatech.in1.apiqcloud.com%2F");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("sumeet.gaikwad@aasa.tech");
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.close();
	}
}
