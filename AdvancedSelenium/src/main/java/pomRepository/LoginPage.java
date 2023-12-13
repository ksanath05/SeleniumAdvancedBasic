package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	//@FindBy(name="user_password")
	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type=\"password\"]")})
	private WebElement PasswordTextField;
	
	//@FindBy(id="submitButton")
	@FindAll({@FindBy(css="input[type=\"submit\"]"),@FindBy(id="submitButton")})
	private WebElement LoginButton;
	
	//getter method

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//business logics/libraries
	
	/**
	 * This is used to login to the application
	 * @param Username
	 * @param Passowrd
	 */
	
	public void loginToApplication (String Username, String Passowrd)
	{
		UserTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Passowrd);
		LoginButton.click();
	}

}
