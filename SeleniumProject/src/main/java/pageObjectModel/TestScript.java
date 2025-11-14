package pageObjectModel;

import java.io.IOException;

public class TestScript extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException{
		BaseClass BC = new BaseClass();
		BC.setup();
		LogIn_Page LP = new LogIn_Page(driver);
		FileLibClass FI = new FileLibClass();
		String validusername = FI.readProperty(Config, "username");
		String validpassword = FI.readProperty(Config, "password");
		Recipe_Page RC = new Recipe_Page(driver);
		String recipename = RC.enterinsearchfield("Hot Chocolate");
		LP.validuser(validusername, validpassword);
		Thread.sleep(5000);
		RC.enterinsearchfield(recipename);
		
		Home_Page HP = new Home_Page(driver);
		HP.logout();
		
		BC.teardown();
		
	}

}
