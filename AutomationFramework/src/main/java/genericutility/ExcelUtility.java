package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * These methods are used to send data from excel file
 * user need to pass sheet name,rowIndex and colIndex 
 * @param sheet
 * @param rowIndex
 * @param colIndex
 * @return 
 * @throws EncryptedDocumentException  
 * @throws IOException
 */

public class ExcelUtility {
	public String getStringDataFromExcel(String sheet, int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
	}
	public double getNumericDataFromExcel(String sheet, int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		
	}
	public boolean getBooleanDataFromExcel(String sheet, int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
		
	}
	public LocalDateTime getLocalDateTimeFromExcel(String sheet, int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
}
