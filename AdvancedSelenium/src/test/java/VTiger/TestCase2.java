package VTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String FN = "3";
		String LN = "4";
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FN);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LN);
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		String CN1 = driver.findElement(By.id("mouseArea_First Name")).getText();
		String CN2 = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		if(CN1.contains(FN)) {
			if(CN2.contains(LN)) {
				System.out.println("Contact created");
			}
			else {
				System.out.println("Contact not created");
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
