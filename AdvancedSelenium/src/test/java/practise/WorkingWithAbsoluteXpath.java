package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAbsoluteXpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("file:///C:/Users/Sanmai/Downloads/Locators%20demo.html");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("FNN");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[2]")).sendKeys("LNN");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[3]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/input[6]")).sendKeys("use1");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[7]")).sendKeys("pass@");
		driver.findElement(By.xpath("/html/body/div[2]/form/button[1]")).click();	

	}

}
