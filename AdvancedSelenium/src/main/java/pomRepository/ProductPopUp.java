package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPopUp {
	
	public ProductPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchFiled;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement clickButton;
	
	@FindBy(xpath="//a[text()='\"+PrdName+\"']")
	private WebElement clickText;

	public WebElement getSearchFiled() {
		return searchFiled;
	}

	public WebElement getClickButton() {
		return clickButton;
	}

	public WebElement getClcikText() {
		return clickText;
	}
	
	public void clickSearch(String Name)
	{
		searchFiled.sendKeys(Name);
	}
	
	public void searchClick()
	{
		clickButton.click();
	}
	
	public void getTxt()
	{
		clickText.click();
	}

}
