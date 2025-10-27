package Package_One;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class_02 {
	 WebDriver driver;
	 String username = "admin";
	 String password = "admin";
	@BeforeTest
    public void beforetest() {
        // Correct ChromeDriver path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}
	@Test
	public void test_01() throws InterruptedException {
		String url = "https://the-internet.herokuapp.com/basic_auth";
        String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.get(authUrl);
        Thread.sleep(6000);
        String pagetitle = driver.getTitle();
        System.out.println("The page title is" + pagetitle);
        
	}
	@Test
	public void test_02() {
		String pagesource = driver.getPageSource();
		Assert.assertTrue(pagesource.contains("Congratulations! You must have the proper credentials."));
		System.out.println("Page content verified successfully");
	}
	@AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
	}
}
