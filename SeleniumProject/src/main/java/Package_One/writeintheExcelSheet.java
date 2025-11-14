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

public class writeintheExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Validdata");
		Row rowcount = sh.getRow(2);
		Cell cell = rowcount.createCell(0);
		
		cell.setCellValue("sumeetgaikwad222@gmail.com");
		FileOutputStream fos = new FileOutputStream("./data/ValidExcelSheet.xlsx.xlsx");
		wb.write(fos);
	}

}
