package Package_One;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert; // ✅ Correct TestNG import
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenChromeBrowser {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        // Correct ChromeDriver path
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize class-level driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void test1() {
        // Click on "Add/Remove Elements" link
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();

        // Click on "Add Element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();

        // Find the Delete button
        WebElement deleteButton = driver.findElement(By.xpath("//div//button[text()='Delete']"));

        // Assert that Delete button is visible
        Assert.assertTrue(deleteButton.isDisplayed(), "Delete button is not visible!");
        System.out.println("Delete button is visible: " + deleteButton.isDisplayed());
    }

    @AfterTest
    public void close_browser() {
        if(driver != null) {
            driver.quit();
        }
    }
}
