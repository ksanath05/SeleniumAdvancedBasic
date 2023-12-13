package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.Webdriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateProductPgae;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductPlusSign;
import pomRepository.ProductValidation;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		File_Utilities flib = new File_Utilities();
		Java_Utilities jlib = new Java_Utilities();
		Excel_Utilities elib = new Excel_Utilities();
		Webdriver_Utilities wlib = new Webdriver_Utilities();
		
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
//		Properties pro = new Properties();
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
//		
		//using business logic/libraries
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
	//	driver.findElement(By.linkText("Products")).click();
		
		HomePage home = new HomePage(driver);
		home.clickOnProducts();
		
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clcikOnPlusProduct();
		
		
		//random approach to avoid duplicates
		int ranNum = jlib.getRandomNum();
	/*	Random ran = new Random();
		int ranNum = ran.nextInt(1000);*/
		//String pname = "Mobile"+ranNum;
		//Fetching data from Excel
//		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
//		Workbook book = WorkbookFactory.create(fis1);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String PrdName = cel.getStringCellValue()+ranNum;
		String PrdName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		
//		driver.findElement(By.name("productname")).sendKeys(PrdName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		CreateProductPgae product = new CreateProductPgae(driver);
		product.productName(PrdName);
		product.clickOnSave();
		
//		String prdname = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		ProductValidation validate = new ProductValidation(driver);
		String prdname = validate.getValidateProduct().getText();
		
		if(prdname.contains(PrdName))
		{
			System.out.println("Product Created");
		}
		else
		{
			System.out.println("Product not created");
		}

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		home.Logout();
		

	}

}
