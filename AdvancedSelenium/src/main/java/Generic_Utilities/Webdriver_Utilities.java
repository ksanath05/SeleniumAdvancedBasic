package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriver_Utilities {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizingWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizingWindows(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to add implicit wait or wait  elements to get loaded in GUI
	 * @param driver
	 */
	public void implicitelyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used for switching windows
	 * @param driver
	 * @param partialVisibleText
	 */
	public void windowSwitching(WebDriver driver, String partialVisibleText)
	{
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> win = allWin.iterator();
		
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			
			if(title.contains("partialVisibleText"))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This is to accept the alert
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	
	
	/**
	 * This is to dismiss the alert
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
}
