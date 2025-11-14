package practice_page_object_model;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass implements IAutoConstant{
	static WebDriver driver;
	public void setup() throws IOException
	{
		File fc = new File();
		String browser = fc.readProperty(Config, "browser");
		String URL = fc.readProperty(Config, "url");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
	}
	public void teardown()
	{
		driver.close();
	}

}
