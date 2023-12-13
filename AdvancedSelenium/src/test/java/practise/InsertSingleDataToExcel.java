package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcel {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fes = new FileInputStream("./src/test/resources/MyExcelData.xlsx");
		FileInputStream fes = new FileInputStream("C:\\Our Folder\\AdvSeleniumSK\\Book2.xlsx");
		
		// Step 2: Open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);
		
		// Step 3: Get control to the sheet
		
		Sheet sheet = book.getSheet("Sheet1");
		
		Row row = sheet.createRow(0);
		
		Cell cel = row.createCell(0);
		
		cel.setCellValue("Qspiders");
		
		FileOutputStream fos = new FileOutputStream("C:\\Our Folder\\AdvSeleniumSK\\Book2.xlsx");
		book.write(fos);
		book.close();

	}

}
