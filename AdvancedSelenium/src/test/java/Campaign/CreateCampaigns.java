package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.Webdriver_Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CampaignPlusSign;
import pomRepository.CreateCampaignPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ValidationPage;


public class CreateCampaigns {

	@Test 
	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
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
		//Hard coding
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//getter methods
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//using business logic/libraries
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		/*driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();*/
		
		HomePage home = new HomePage(driver);
		home.clickOnMoreLink();
		home.clickOnCampaignLink();
		
		//Random Approach To avoid Duplicates
		int ranNum = jlib.getRandomNum();
		/*Random ran = new Random();
		int ranNum = ran.nextInt(1000);*/
		//String campName = "Marketing"+ranNum;
		
		//Fetching data from Excel
//				FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xslx.xlsx");
//				Workbook book = WorkbookFactory.create(fes);
//				Sheet sheet = book.getSheet("Campaigns");
//				Row row = sheet.getRow(0);
//				Cell cel = row.getCell(0);
//				String CampName = cel.getStringCellValue()+ranNum;
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampaignPlusSign plus = new CampaignPlusSign(driver);
		plus.clickOnPlusCampaign();
		String CampName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
				
//		driver.findElement(By.name("campaignname")).sendKeys(CampName);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateCampaignPage campaign = new CreateCampaignPage(driver);
		campaign.campaignName(CampName);
		campaign.clickOnSave();
		
		//String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
		ValidationPage campValidate = new ValidationPage(driver);
		String campaignName = campValidate.getValidateCampaign().getText();
		
		
		if(campaignName.contains(CampName))
		{
			System.out.println("Campaign Created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
		
//	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		
		home.Logout();
	}

}
