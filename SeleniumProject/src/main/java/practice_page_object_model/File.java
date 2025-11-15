package practice_page_object_model;

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

public class File {
	
	public void readexceldata() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook Wb = WorkbookFactory.create(fis);
		Sheet sh = Wb.getSheet("Validdata");
		Row rowcount = sh.getRow(1);
		Cell cell = rowcount.getCell(0);
		String data = cell.getStringCellValue();
		System.out.println(data);
	}
	public void writeinexcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sheet = wb1.getSheet("Validdata");
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.createCell(3);
		cell1.setCellValue("gaikwwad");
		
		FileOutputStream foi = new FileOutputStream("./data/ValidExcelSheet.xlsx.xlsx");
		wb1.write(foi);
	}
	public String readProperty(String config, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
