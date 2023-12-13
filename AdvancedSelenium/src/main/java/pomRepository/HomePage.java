package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Campaigns Page
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	//Organizations Page
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	//Products Page
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	//Logout action
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminButton;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	//getter methods for campaigns
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	//getter method for organizations
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	//getter method for product
	public WebElement getProductsLink() {
		return productsLink;
	}
	
	//getters for signout
	public WebElement getAdminButton() {
		return adminButton;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}


	//Business logics for campaigns
	public void clickOnMoreLink()
	{
		moreLink.click();
	}

	public void clickOnCampaignLink()
	{
		campaignsLink.click();
	}
	
	//business logics for organization
	public void clickOnOrganization()
	{
		OrganizationLink.click();
	}
	
	//business logics for product
	public void clickOnProducts()
	{
		productsLink.click();
	}
	
	//business logic for signout
	public void Logout()
	{
		adminButton.click();
		signOutLink.click();
	}
	
	//or using actions class
//	public void Logout(WebDriver driver)
//	{
//		WebDriver_Utility wlib=new WebDriver_Utility();
//		wlib.ActionsMoveToElement(driver, AdminisatorSign);
//		signOutLink.click();
//	}
	
}
