package pageObjectModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetTesting {
	
	public String  readExcelData(String excelPath, String excelSheet, int rowCount, int cellcount) throws EncryptedDocumentException, IOException {
		/*
		 * FileInputStream fis = new FileInputStream(excelPath); return
		 * WorkbookFactory.create(fis).getSheet(excelSheet).getRow(rowCount).getCell(
		 * cellcount).getStringCellValue();
		 */
		
	
	FileInputStream fis = new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(excelSheet);
	Row row = sh.getRow(rowCount);
	Cell cell = row.getCell(cellcount);
	String data = cell.getStringCellValue();
	return data;
	}
	
	public void  writeExcelData(String excelPath, String excelSheet, int rowCount, int cellcount, String data) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(excelSheet);
	Row row = sh.getRow(rowCount);
	Cell cell = row.createCell(cellcount);
	cell.setCellValue(data);
	FileOutputStream fos = new FileOutputStream(excelPath);
	wb.write(fos);
	}
	
}
