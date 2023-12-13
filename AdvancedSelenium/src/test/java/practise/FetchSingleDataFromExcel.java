package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		//Step 1: Set the path or give the path of the excel and create the object of it
		//FileInputStream fes = new FileInputStream("./src/test/resources/MyExcelData.xlsx");
		FileInputStream fes = new FileInputStream("C:\\Users\\Sanmai\\Desktop\\MyExcelData.xslx");
		
		// Step 2: Open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);
		
		// Step 3: Get control to the sheet
		
		Sheet sheet = book.getSheet("FirstData");
		
		// Step 4: get control of row
		
		Row row = sheet.getRow(0);
		
		// Step 5: get control of cell
		
		Cell cel = row.getCell(0);
		
		String ExcelData = cel.getStringCellValue();
		
		System.out.println(ExcelData);
		
	}

}
