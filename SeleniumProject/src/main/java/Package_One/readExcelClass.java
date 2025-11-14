package Package_One;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readExcelClass{
	
	public String writeinexcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Validdata");
		Row row = sheet.getRow(0);
		Cell cell = row.createCell(2);
		cell.setCellValue("Sumeet");
		FileOutputStream fos = new FileOutputStream("ValidExcelSheet.xlsx.xlsx");
		wb.write(fos);
		
		return null;
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		readExcelClass obj = new readExcelClass();
		obj.writeinexcel();
	}
}
