package package_package;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Script_Class extends BaseClass {
	public static void main(String[] args) throws IOException {

        BaseClass BC = new BaseClass();
        driver = BC.setup(); // ✅ get the initialized driver

        Location LC = new Location(driver);
        LC.interact();
    }
}
