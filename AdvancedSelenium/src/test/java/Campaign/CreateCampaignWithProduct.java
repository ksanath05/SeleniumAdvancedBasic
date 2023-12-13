package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import pomRepository.CampaignPlusSign;
import pomRepository.CreateCampaignPage;
import pomRepository.CreateProductPgae;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductPlusSign;
import pomRepository.ProductPopUp;
import pomRepository.ProductValidation;

public class CreateCampaignWithProduct {

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
		//Hardcoding
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Getter method
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//using business logic/libraries
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		
//		driver.findElement(By.linkText("Products")).click();
		
		HomePage home = new HomePage(driver);
		home.clickOnProducts();
		
//		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		ProductPlusSign plus = new ProductPlusSign(driver);
		plus.clcikOnPlusProduct();
		
//		HomePage home = new HomePage(driver);
//		home.clickOnProducts();
		
		//Random number generation
		int ranNum = jlib.getRandomNum();
		
		//or this is also fine driver.findElement(By.name("productname")).sendKeys(pname+ranNum);
		
		//Fetching data from Excel
//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Campaigns");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String CampName = cel.getStringCellValue()+ranNum;
//		Sheet sheet1 = book.getSheet("Product");
//		Row row1 = sheet1.getRow(0);
//		Cell cel1 = row1.getCell(0);
//		String PrdName = cel1.getStringCellValue()+ranNum;
		
		String CampName = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
		String PrdName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		//
		//;
		// To create Product
//		driver.findElement(By.name("productname")).sendKeys(PrdName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		CreateProductPgae product = new CreateProductPgae(driver);
		product.productName(PrdName);
		product.clickOnSave();
		
//		String vname = driver.findElement(By.id("mouseArea_Product Name")).getText();
		
		ProductValidation validate = new ProductValidation(driver);
		String vname = validate.getValidateProduct().getText();
		
		if(vname.contains(PrdName)) {
			System.out.println("Product created");
		}
		else {
			System.out.println("Product not created");
		}
		
		
		//To create campaign
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();
		
		home.clickOnMoreLink();
		home.clickOnCampaignLink();
		
//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		CampaignPlusSign cplus = new CampaignPlusSign(driver);
		cplus.clickOnPlusCampaign();
		
	//	driver.findElement(By.name("campaignname")).sendKeys(CampName);
		//
//		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.campaignName(CampName);
		campaign.clickOnSave();
		
	//	//Set<String> child = driver.getWindowHandles();
		//for (String b :child) {
			//driver.switchTo().window(b);
	//	}
		// to switch to child window
		
		wlib.windowSwitching(driver, "Products&Actions");
//		Set<String> allWin = driver.getWindowHandles();
//		Iterator<String> win = allWin.iterator();
//		
//		while(win.hasNext())
//		{
//			String winText = win.next();
//			driver.switchTo().window(winText);
//			String title = driver.getTitle();
//			
//			if(title.contains("Products&Actions"))
//			{
//				break;
//			}
//		}
		
//	driver.findElement(By.id("search_txt")).sendKeys(PrdName);
//		driver.findElement(By.xpath("//input[@type='button']")).click();
		
		ProductPopUp popup = new ProductPopUp(driver);
		popup.clickSearch(PrdName);
		popup.searchClick();
		
		//dynamic path
//		
//		driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
//		
//		// to switch to parent window
//		
//		wlib.windowSwitching(driver, "Campaigns&action");
//		
////		Set<String> allWin1 = driver.getWindowHandles();
////		Iterator<String> win1 = allWin1.iterator();
////
////		while(win1.hasNext())
////		{
////			String winText1 = win1.next();
////		driver.switchTo().window(winText1);
////		String title1 = driver.getTitle();
////
////		if(title1.contains("Campaigns&action"))
////		{
////			break;
////		}
////
////		}
//		
//		//To create campaign
//		driver.findElement(By.name("campaignname")).sendKeys(CampName);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//			
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
