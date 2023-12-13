package Organization;

import java.io.FileInputStream;
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
import pomRepository.CreateOrgPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrgPlus;
import pomRepository.OrgValidation;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
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
		
		//click on create org link
		//driver.findElement(By.linkText("Organizations")).click();
		
		HomePage home=new HomePage(driver);
		home.clickOnOrganization();
		
		//click on lookup image+sign
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		OrgPlus create = new OrgPlus(driver);
		create.clickOnOrg();
		
		// random approach to avoid duplicate
		int ranNum = jlib.getRandomNum();
		
		/*Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		*/
		// navigate to create organization page - provide org name
		//String Name = "Qspiders"+ranNum;
		
		//Fetching data from Excel
//		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Organization");
//		Row row = sheet.getRow(0);
//		Cell cel = row.getCell(0);
//		String OrgName = cel.getStringCellValue()+ranNum;
		
		String OrgName = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
		
//		driver.findElement(By.name("accountname")).sendKeys(OrgName);
//		driver.findElement(By.name("button")).click();
		
		CreateOrgPage org = new CreateOrgPage(driver);
		org.createOrgName(OrgName);
		org.clickOnSave();
		
		Thread.sleep(2000);
		
		//validate org name is created
//		String PrdName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();	
//		String PrdName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
		
		OrgValidation validate = new OrgValidation(driver);
		String PrdName = validate.getOrgName().getText();
		
		if(PrdName.contains(OrgName)){
			System.out.println("Organization Created");
		}
		else {
			System.out.println("Organization not created");
		}
		
		Thread.sleep(2000);
		
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		home.Logout();
	}

}
