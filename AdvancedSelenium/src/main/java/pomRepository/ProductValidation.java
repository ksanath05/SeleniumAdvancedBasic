package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation {

	public ProductValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement validateProduct;

	public WebElement getValidateProduct() {
		return validateProduct;
	}
	
	public void ProdValidate()
	{
		validateProduct.getText();
	}
	
	
}
