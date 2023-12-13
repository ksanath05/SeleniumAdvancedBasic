package VTiger;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		String FN = "1";
		String LN = "2";
		String CN = "3";
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FN);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LN);
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(CN);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String FNV = driver.findElement(By.id("mouseArea_First Name")).getText();
		String LNV = driver.findElement(By.id("mouseArea_Last Name")).getText();
		String CNV = driver.findElement(By.id("mouseArea_Company")).getText();
		if(FNV.contains(FN)) {
			if(LNV.contains(LN)) {
				if(CNV.contains(CN)) {
					System.out.println("Validation Passed");
				}
				else {
					System.out.println("Validation Failed");
				}
			}
		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
