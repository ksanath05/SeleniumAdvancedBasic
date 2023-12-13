package VTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//click on create org link
		driver.findElement(By.linkText("Organizations")).click();
		//click on lookup image+sign
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// navigate to create organization page - provide org name
		String Name = "Qspiders6";
		driver.findElement(By.name("accountname")).sendKeys(Name);
		driver.findElement(By.name("button")).click();
		//validate org name is created
		Thread.sleep(2000);
		String OrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();	
		if(OrgName.contains(Name)){
			System.out.println("Organization Created");
		}
		else {
			System.out.println("Organization not created");
		}
		
		Thread.sleep(2000);
		
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
