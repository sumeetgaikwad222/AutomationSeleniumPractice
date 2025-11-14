package Package_One;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class DataDrivenTesting {

    private static final File ts = null;

	public void readexcel(String filepath, String filename, String sheetname) throws IOException, InterruptedException {
        // Open Excel file
        File file = new File(filepath + "\\" + filename);
        FileInputStream fis = new FileInputStream(file);

        // Create workbook
        Workbook loginworkbook = org.apache.poi.ss.usermodel.WorkbookFactory.create(fis);

        // Get sheet
        Sheet loginsheet = loginworkbook.getSheet(sheetname);

        // Get total number of rows
        int rowcount = loginsheet.getLastRowNum();

        // Loop through rows (starting from 1 because row 0 is header)
        for (int i = 1; i <= rowcount; i++) {
            Row getrow = loginsheet.getRow(i);
            String username = getrow.getCell(0).toString();
            String password = getrow.getCell(1).toString();

            // Call test method for each row
            test(username, password);
        }

        // Close workbook and file stream
        loginworkbook.close();
        fis.close();
    }

    @SuppressWarnings("deprecation")
    public void test(String username, String password) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String baseurl = "https://nutra-menu.in1.apiqcloud.com/";
        driver.get(baseurl);

        driver.findElement(By.id("login-form_email")).sendKeys(username);
        driver.findElement(By.id("login-form_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Test done for: " + username);
        Thread.sleep(8000);
        TakesScreenshot ts = (TakesScreenshot) driver;
        ts.getScreenshotAs(OutputType.FILE);
        Files.copy((File) ts, new File("C:\\Users\\SUMEET GAIKWAD\\OneDrive\\Pictures\\Selenium Screenshots\\amazonscreeshot.jpg"));

        driver.quit(); // close browser after each test
        driver.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        DataDrivenTesting classobj = new DataDrivenTesting();
        String filelocation = "C:\\Users\\SUMEET GAIKWAD\\OneDrive\\Documents";
        classobj.readexcel(filelocation, "inputdata.xlsx", "Sheet1");
    }
}
