package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertMultipleData {

	public static void main(String[] args) throws Throwable {
FileInputStream fes = new FileInputStream("C:\\Our Folder\\AdvSeleniumSK\\Book2.xlsx");
		
		// Step 2: Open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);
		
		// Step 3: Get control to the sheet
		
		Sheet sheet = book.getSheet("Sheet2");
		
		Row row = sheet.createRow(0);
		Cell cel = row.createCell(0);
		cel.setCellValue("Volvo");
		
		Row row1 = sheet.createRow(2);
		Cell cel1 = row1.createCell(2);
		cel1.setCellValue("Audi");
		
		Row row2 = sheet.createRow(4);
		Cell cel2 = row2.createCell(4);
		cel2.setCellValue("BMW");
		
		FileOutputStream fos = new FileOutputStream("C:\\Our Folder\\AdvSeleniumSK\\Book2.xlsx");
		book.write(fos);
		book.close();
	

	}

}
