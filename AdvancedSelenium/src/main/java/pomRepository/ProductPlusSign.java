package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPlusSign {
	
	public ProductPlusSign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productPlus;

	public WebElement getProductPlus() {
		return productPlus;
	}
	
	public void clcikOnPlusProduct()
	{
		productPlus.click();
	}

}
