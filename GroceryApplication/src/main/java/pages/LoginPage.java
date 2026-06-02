package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utitilities.WaitUtility;

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
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/home' and text()='More info ']")WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginTitle;
	
	public LoginPage enterUsernameInUsernanefield(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}
	
	
	public LoginPage enterPasswordInPasswordfield(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}

	
	public HomePage loginButtonClick()
	{
		WaitUtility wait=new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, submit);
		submit.click();
		return new HomePage(driver);
	}
public boolean dashboardDisplay()
{
	return dashboard.isDisplayed();
}

public String textDisplay()
{
	return loginTitle.getText();
}
}
