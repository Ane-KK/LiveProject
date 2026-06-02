package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utitilities.PageUtility;

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
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement userReset;
	

	public AdminUserPage newUserbutton()
	{
		newUser.click();
		return this;
	}
	public AdminUserPage enterUsernameInUsernanefield(String usernamevalue)
	{
		enterUsername.sendKeys(usernamevalue);
		return this;
	}
	public AdminUserPage enterPasswordInPasswordfield(String passwordvalue)
	{
		enterPassword.sendKeys(passwordvalue);
		return this;
		
	}
	
	public AdminUserPage selectUserType()
	{
		PageUtility page=new PageUtility();
		page.selectDropdownByVisibleText(dropdownType, "Admin");
		
		//Select select= new Select(dropdownType);
		//select.selectByVisibleText("Admin");
		
		return this;
	}

	public AdminUserPage saveClick()
	{
		clickSave.click();
		return this;
	}
	
	public AdminUserPage searchUser()
	{
		search.click();
		return this;
	}
	public AdminUserPage searchname(String usernamevalue)
	{
		searchUsername.sendKeys(usernamevalue);
		return this;
	}
	
	public AdminUserPage searchUserType()
	{
		Select select= new Select(searchdropdownType);
		select.selectByVisibleText("Admin");
		return this;
	}
	
	public AdminUserPage searchUserButton()
	{
		searchButton.click();
		return this;
		
	}
	
	public AdminUserPage resetUser()
	{
		userReset.click();
		return this;
	}
}

