package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text' and @name='username']")WebElement username;
	@FindBy(xpath="//input[@type='password' and @name='password']")WebElement password;
	@FindBy(xpath="//button[@type='submit' and @class='btn btn-dark btn-block']")WebElement submit;
	

	
	public void enterUsernameInUsernanefield(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
	}
	
	
	public void enterPasswordInPasswordfield(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}

	
	public void loginButtonClick()
	{
		submit.click();
	}

}
