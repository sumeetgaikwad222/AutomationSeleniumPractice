package from_the_scrach;

import org.openqa.selenium.WebDriver;;

public class Script_Class extends Base_Class{
	
	public static void main(String[] args) throws InterruptedException {
		Base_Class BC = new Base_Class();
		BC.lauch(); 
		Thread.sleep(3000);
		Locator_page LC = new Locator_page(driver); 
		LC.openfield();
		Thread.sleep(3000);
		BC.teardown();
	}

}
