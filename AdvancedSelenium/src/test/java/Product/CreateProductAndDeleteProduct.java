package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.Webdriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateProductPgae;
import pomRepository.DeleteProductPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductPlusSign;
import pomRepository.ProductValidation;

public class CreateProductAndDeleteProduct {

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
		
		//using business logic/libraries
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		

		//driver.findElement(By.linkText("Products")).click();
		
		HomePage home = new HomePage(driver);
		home.clickOnProducts();
		
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clcikOnPlusProduct();

		// Random Approach To avoid Duplicates
//	Random ran = new Random();
		// int ranNum = ran.nextInt(1000);
		int ranNum = jlib.getRandomNum();

//	String NAme = "Phone"+ranNum;

		// Fetching data from Excel
//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Product");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String PrdName = cel.getStringCellValue() + ranNum;
		
		String PrdName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;

//		driver.findElement(By.name("productname")).sendKeys(PrdName);
//		System.out.println(PrdName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateProductPgae product = new CreateProductPgae(driver);
		product.productName(PrdName);
		product.clickOnSave();
		System.out.println(PrdName);

//		String prdname = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		
		ProductValidation validate = new ProductValidation(driver);
		String prdname = validate.getValidateProduct().getText();

		if (prdname.contains(PrdName)) {
			System.out.println("Product Created");
		} else {
			System.out.println("Product not created");
		}

		driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();

		driver.findElement(By.xpath("//a[text()='" + PrdName + "']/../preceding-sibling::td/input")).click();

	//	driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		DeleteProductPage delete = new DeleteProductPage(driver);
		delete.deletePrdData();
		
		// to accept the alert
//		Alert alt = driver.switchTo().alert();
//		alt.accept();
		
		wlib.alertAccept(driver);

//validation
		/*List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));

		boolean flag = false;

		for (WebElement prd : prdList) {
			String actData = prd.getText();// phone456
			if (actData.contains(PrdName))// phone360
			{
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("product deleted");
		} else {
			System.out.println("Product not deleted");
		}*/
		
		delete.validateProduct(driver, prdname);
		

//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		home.Logout();

	}

}
