package pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Webdriver_Utilities;

public class DeleteProductPage {

	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement navigateProductTable;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteProduct;

	public WebElement getNavigateProductTable() {
		return navigateProductTable;
	}

	public WebElement getDeleteProduct() {
		return DeleteProduct;
	}
	
	public void productTable()
	{
		navigateProductTable.click();
	}
	
	public void deletePrdData()
	{
		DeleteProduct.click();
	}
	
	public void validateProduct(WebDriver driver, String PrdName) {
		List<WebElement> prdList = driver
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
		}
	}
	
	
}
