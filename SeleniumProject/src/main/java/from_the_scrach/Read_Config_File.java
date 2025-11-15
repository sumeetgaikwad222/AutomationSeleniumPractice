package from_the_scrach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Read_Config_File implements IConstant {
	
	public String readconfi(String prop, String Key) throws IOException
	{
		FileInputStream FIS = new FileInputStream(Config);
		Properties propeties = new Properties();
		propeties.load(FIS);
		String value = propeties.getProperty(Key);
		return value;
	}

}
