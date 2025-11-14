package pageObjectModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibClass {
	public String readExcelData(String excelpath, String sheetname, int rowCount, int cellcount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowCount);
		Cell cell = row.getCell(cellcount);
		String data = cell.getStringCellValue();
		return data;	
	}
	public void writedata(int data) throws EncryptedDocumentException, IOException
	{
		FileInputStream filb = new FileInputStream("./data/ValidExcelSheet.xlsx.xlsx");
		Workbook wb1 = WorkbookFactory.create(filb);
		Sheet sh1 = wb1.getSheet("Validdata");
		Row rowcount = sh1.getRow(0);
		Cell cell = rowcount.createCell(3);
		cell.setCellValue(data);
	}
	
	public Object[][] readAllExcelData(String excelpath, String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream objfis = new FileInputStream(excelpath);
		Workbook objwb = WorkbookFactory.create(objfis);
		Sheet objsh = objwb.getSheet(sheetname);
		int objrow = objsh.getLastRowNum();
		int totalCols = objsh.getRow(0).getLastCellNum();
		// Step 4: Create 2D array to store data
				Object[][] data = new Object[objrow][totalCols];
				
				// Step 5: Read data row by row (skip row 0 which is header)
				DataFormatter formatter = new DataFormatter(); // This converts any cell type to String
				for (int i = 1; i <= objrow; i++) {
					Row row = objsh.getRow(i);
					
					// Read each cell in the row
					for (int j = 0; j < totalCols; j++) {
						Cell cell = row.getCell(j);
						data[i-1][j] = formatter.formatCellValue(cell); // Store cell value as String
					}
				}
				objwb.close();
				objfis.close();
				return data;
	}
	public String readProperty(String proppath, String key) throws IOException
	{
		FileInputStream prop = new FileInputStream(proppath);
		Properties properties = new Properties();
		properties.load(prop);
		String value = properties.getProperty(key);
		return value;
	}
}
