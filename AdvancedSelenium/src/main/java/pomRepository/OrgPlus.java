package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPlus {

	public OrgPlus(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement orgPlus;

	public WebElement getOrgPlus() {
		return orgPlus;
	}
	
	public void clickOnOrg()
	{
		orgPlus.click();
	}
	
	
	
	
	
	
}
