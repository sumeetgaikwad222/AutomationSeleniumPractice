package package_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ForExcelaction {
	
	public void readexcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Validdata");
		Row rowcount = sh.getRow(0);
		Cell cell = rowcount.getCell(0);
		String data = cell.getStringCellValue();
	}
	public void writeexcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sh1 = wb1.getSheet("Validdata");
		Row rowcount1 = sh1.getRow(0);
		Cell cell1 = rowcount1.createCell(3);
		String data1 = cell1.getStringCellValue();
		cell1.setCellValue("Sumeet");
		
		FileOutputStream fos = new FileOutputStream("./data/ValidExcelSheet.xlsx.xlsx");
		wb1.write(fos);
	}
	public String readconfigfile(String reacon, String key) throws IOException
	{
		FileInputStream fis2 = new FileInputStream("./data/config.properties");
		Properties prop = new Properties();
		prop.load(fis2);
		String readcon = prop.getProperty(key);
		return readcon;
	}
}
