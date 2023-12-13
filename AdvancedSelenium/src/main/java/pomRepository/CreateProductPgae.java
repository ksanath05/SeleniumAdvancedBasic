package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPgae {
	
	public CreateProductPgae(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement createProduct;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

	public WebElement getCreateProduct() {
		return createProduct;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void productName(String Name)
	{
		createProduct.sendKeys(Name);
	}
	
	public void clickOnSave()
	{
		saveButton.click();
	}

}
