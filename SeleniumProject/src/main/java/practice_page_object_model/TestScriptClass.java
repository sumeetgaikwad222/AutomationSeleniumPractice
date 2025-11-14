package practice_page_object_model;

import java.io.IOException;

public class TestScriptClass extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseClass BC = new BaseClass();
		BC.setup();
		Login_Page LP = new Login_Page(driver);
		File FC = new File();
		String username = FC.readProperty(Config, "username");
		String password = FC.readProperty(Config, "password");
		LP.validcreads(username, password);
		
		Home_Page HP = new Home_Page(driver);
		HP.enterintextbox();
		
		Company_Profile_Page CP = new Company_Profile_Page(driver);
		CP.addoutlet();
		
		HP.logout();
		
	}
}
