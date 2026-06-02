package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and text()=' New']")WebElement addNews;
	@FindBy(id="news")WebElement enterNews;
	@FindBy(xpath="//button[@type='submit' and @name='create']")WebElement newsSave;
	@FindBy(xpath="//a[@href='javascript:void(0)' and text()=' Search']")WebElement searchNews;
	@FindBy(xpath="//input[@name='un' and @type='text']")WebElement enterNewsTitle;
	@FindBy(xpath="//button[@type='submit' and @name='Search']")WebElement submitSeach;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and text()=' Reset']")WebElement resetbutton;
	
	public ManageNewsPage createNews()
	{
		addNews.click();
		return this;
	}
	public ManageNewsPage enterNewsTitle(String newsvalue)
	{
		enterNews.sendKeys(newsvalue);
		return this;
	}
	public ManageNewsPage saveNews()
	{
		newsSave.click();
		return this;
	}
	
	public ManageNewsPage clickNewsSeach()
	{
		searchNews.click();
		return this;
	}
	
	public ManageNewsPage searchNewsTitle(String newsvalue)
	{
		enterNewsTitle.sendKeys(newsvalue);
		return this;
	}
	public ManageNewsPage seachSubmit()
	{
		submitSeach.click();
		return this;
	}
	public ManageNewsPage resetNews()
	{
		resetbutton.click();
		return this;
	}
}
