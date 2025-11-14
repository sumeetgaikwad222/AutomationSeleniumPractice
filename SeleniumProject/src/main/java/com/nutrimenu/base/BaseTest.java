package com.nutrimenu.base;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Package_One.TakeScreenshot_Class;

import java.time.Duration;

/**
 * BASE CLASS - This runs BEFORE and AFTER every test
 * Think of this as: Opening and Closing the browser
 * 
 * MANUAL DRIVER SETUP VERSION (No WebDriverManager)
 */
public class BaseTest {
    
    // WebDriver = Remote control for browser
    protected WebDriver driver;
    
    // Website URL
    protected static final String BASE_URL = "https://nutra-menu.in1.apiqcloud.com/fbo/dashboard";
    
    /**
     * @BeforeMethod = Runs BEFORE each test
     * This opens the browser and goes to website
     */
    @BeforeMethod
    public void setUp() {
        System.out.println("==== OPENING BROWSER ====");
        
        // OPTION 1: Manual ChromeDriver Setup
        // Download chromedriver from: https://chromedriver.chromium.org/
        // Put the path to your chromedriver.exe below
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        // OPTION 2: If ChromeDriver is in System PATH, comment above line
        
        // Open Chrome browser
        driver = new ChromeDriver();
        
        // Maximize window
        driver.manage().window().maximize();
        
        // Set wait time (if element not found, wait 10 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Go to website
        driver.get(BASE_URL);
        System.out.println("Opened website: " + BASE_URL);
        
        driver.findElement(By.id("login-form_email")).sendKeys("sumeetgaikwad222@gmail.com");
        driver.findElement(By.id("login-form_password")).sendKeys("12345Su@");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    /**
     * @AfterMethod = Runs AFTER each test
     * This closes the browser
     */
    @AfterMethod
    public void tearDown() {
        System.out.println("==== CLOSING BROWSER ====");
        if (driver != null) {
            driver.quit();
        }
    }
}

/*
 * HOW TO SETUP CHROMEDRIVER MANUALLY:
 * 
 * 1. Check your Chrome version:
 *    - Open Chrome → Three dots → Help → About Google Chrome
 *    - Note the version (e.g., 120.0.6099.109)
 * 
 * 2. Download ChromeDriver:
 *    - Go to: https://chromedriver.chromium.org/downloads
 *    - Download matching version
 * 
 * 3. Extract and place:
 *    - Extract chromedriver.exe
 *    - Put it in: C:/drivers/chromedriver.exe
 *    - OR any folder you want
 * 
 * 4. Update the path in line 27 above
 * 
 * ALTERNATIVE: Add to System PATH
 * - Add the folder containing chromedriver.exe to Windows PATH
 * - Then you can comment out line 27
 */