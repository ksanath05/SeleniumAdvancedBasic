package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities {
	
	public  String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		/** this method is used to fetch data from excel
		 * @author Sanath
		 */
		
		FileInputStream fes = new FileInputStream("/src/test/resources/TestData.xslx.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String ExcelData = cel.getStringCellValue();
		return ExcelData;
				
	}
	
	
	/**
	 * this method is used to fetch data from excelsheet using Formatter
	 * @param SheetName
	 * @param rowNum
	 * @param callNum
	 * @return
	 * @throws Throwable
	 */
	
	public  String getExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		return ExcelData;
		
	}
	
	
	public Object[][] readMultipleData(String SheetName) throws Throwable{
	FileInputStream fis1=new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
    Workbook book=WorkbookFactory.create(fis1);

    Sheet sheet = book.getSheet(SheetName);
    int lastRow = sheet.getLastRowNum()+1;//num of rows
    int lastCell = sheet.getRow(0).getLastCellNum();
    
    Object[][] obj = new Object[lastRow][lastCell];
    for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			obj[i][j]=sheet.getRow(i).getCell(j).toString();
		}
	}
	return obj;
	}
	
	

}