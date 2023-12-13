package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusSign {
	
	public CampaignPlusSign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignPlus;

	public WebElement getCampaignPlus() {
		return campaignPlus;
	}
	
	public void clickOnPlusCampaign()
	{
		campaignPlus.click();
	}
	
}
