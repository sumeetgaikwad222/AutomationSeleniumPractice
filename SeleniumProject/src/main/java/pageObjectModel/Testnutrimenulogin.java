package pageObjectModel;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testnutrimenulogin {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://nutra-menu.in1.apiqcloud.com/");
		//create object from where you fetching the excel data
		ExcelSheetTesting filename = new ExcelSheetTesting();
		//Read the valid username
		
		String validUsername = filename.readExcelData("./data/ValidExcelSheet.xlsx.xlsx","validdata", 1, 0);
		driver.findElement(By.id("login-form_email")).sendKeys(validUsername);		
		
		//Read the valid password
		String validpassword = filename.readExcelData("./data/ValidExcelSheet.xlsx.xlsx","validdata", 1, 1);
		driver.findElement(By.id("login-form_password")).sendKeys(validpassword);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
