package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText=("Admin"))WebElement admin;
	@FindBy(linkText=("Logout"))WebElement logout;
	//@FindBy(xpath="//div[@class='icon']//following::a[@class='small-box-footer' ][1]")WebElement adminUserMoreInfo;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminUserMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")WebElement adminUserMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()='More info ']")WebElement ManageNewsInfo;
	public HomePage clickAdmin()
	{
		admin.click();
		return this;
	}
	
	public AdminUserPage clickAdminUserMoreInfo()
	{
		adminUserMoreInfo.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage clickManageNewsInfo()
	{
		ManageNewsInfo.click();
		return new ManageNewsPage(driver);
	}
	
	public LoginPage clickLogout()
	{
		logout.click();
		return new LoginPage(driver);
	}
}

