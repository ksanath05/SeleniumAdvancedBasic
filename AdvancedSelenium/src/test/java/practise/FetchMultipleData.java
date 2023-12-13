package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleData {

	public static void main(String[] args) throws Throwable {
	FileInputStream fes = new FileInputStream("C:\\Our Folder\\AdvSeleniumSK\\Book2.xlsx");
		
		// Step 2: Open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);
		
		// Step 3: Get control to the sheet
		
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String data1 = cel.getStringCellValue();
		
		Row row1 = sheet.getRow(2);
		Cell cel1 = row1.getCell(2);
		String data2 = cel1.getStringCellValue();
		
		Row row2 = sheet.getRow(6);
		Cell cel2 = row2.getCell(6);
		String data3 = cel2.getStringCellValue();
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);

	}

}
