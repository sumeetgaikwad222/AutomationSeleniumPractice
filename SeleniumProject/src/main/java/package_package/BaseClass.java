package package_package;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass implements IAutoConstant {
	static WebDriver driver;
	public WebDriver setup() throws IOException
	{
		ForExcelaction FExcelclass = new ForExcelaction();
		String broswer = FExcelclass.readconfigfile(Config, "browser");
		String url = FExcelclass.readconfigfile(Config, "url");
		System.setProperty(ChromDriverKey, ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return null;
	}

}