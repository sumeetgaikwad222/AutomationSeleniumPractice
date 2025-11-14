package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass implements Iconstants{
	
	static WebDriver driver;
	public void setup() throws IOException
	{
		FileLibClass flib = new FileLibClass();
		String browservalue = flib.readProperty(Config, "browser");
		String URL = flib.readProperty(Config, "url");
		if (browservalue.equalsIgnoreCase("chrome")) {
			System.setProperty(ChromDriverKey, ChromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
			driver.get(URL);		
	}
		else if(browservalue.equalsIgnoreCase("msedge"))
		{
			FileLibClass gbrowser = new FileLibClass();
			String gbrowservalue = gbrowser.readProperty(Config, "browser");
			String GURL = gbrowser.readProperty(Config, "url");
			System.setProperty(MSEDGEKey, MSEDGEDriverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
			driver.get(GURL);
		}
		else
		{
			System.out.println("Base class failed - Invalid browser: " + browservalue);
            
		}
		
	}
	public void teardown()
	{
		if (driver != null) {
            driver.quit();
        }
	}

}
