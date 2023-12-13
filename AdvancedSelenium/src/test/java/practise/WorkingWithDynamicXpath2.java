package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithDynamicXpath2 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.partialLinkText("Digital downloads")).click();
		List<WebElement> allAddToCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		for (WebElement allToCart : allAddToCart) {
			allToCart.click();
			Thread.sleep(2000);
		}
		
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		List<WebElement> allRemoveCB = driver.findElements(By.xpath("//table[@class='cart']//input[@type='checkbox']"));
		for (WebElement removeCB : allRemoveCB) {
			removeCB.click();
		}
		
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		driver.close();
	}

}
