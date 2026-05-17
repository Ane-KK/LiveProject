package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(1)']")WebElement newUser;
	@FindBy(id="username")WebElement enterUsername;
	@FindBy(id="password")WebElement enterPassword;
	@FindBy(id="user_type")WebElement dropdownType;
	@FindBy(xpath="//button[@type='submit' and @name='Create']")WebElement clickSave;
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(2)']")WebElement search;
	@FindBy(id="un")WebElement searchUsername;
	@FindBy(id="ut")WebElement searchdropdownType;
	@FindBy(xpath="//button[@name='Search' and @value='sr']")WebElement searchButton;
	@FindBy(xpath="//a[text()='Reset' and @class='btn btn-default btn-fix']//parent::div[@class='card-body']")WebElement userReset;
	

	public void newUserbutton()
	{
		newUser.click();
	}
	public void enterUsernameInUsernanefield(String usernamevalue)
	{
		enterUsername.sendKeys(usernamevalue);
	}
	public void enterPasswordInPasswordfield(String passwordvalue)
	{
		enterPassword.sendKeys(passwordvalue);
	}
	
	public void selectUserType()
	{
		Select select= new Select(dropdownType);
		select.selectByVisibleText("Admin");
	}

	public void saveClick()
	{
		clickSave.click();
	}
	
	public void searchUser()
	{
		search.click();
	}
	public void searchname(String usernamevalue)
	{
		searchUsername.sendKeys(usernamevalue);
	}
	
	public void searchUserType()
	{
		Select select= new Select(searchdropdownType);
		select.selectByVisibleText("Admin");
	}
	
	public void searchUserButton()
	{
		searchButton.click();
		
	}
	
	public void resetUser()
	{
		userReset.click();
	}
}

