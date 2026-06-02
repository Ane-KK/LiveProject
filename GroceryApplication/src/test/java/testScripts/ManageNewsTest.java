package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utitilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage home;
	ManageNewsPage newsManage;
	
	
	@Test
	
	public void verifyCreateNewsAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		newsManage=home.clickManageNewsInfo();
		String news="Breaking News";
		//ManageNewsPage newsManage=new ManageNewsPage(driver);
		newsManage.createNews().enterNewsTitle(news).saveNews();
		
	}
	
	@Test
	public void verifySearchNewsAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		newsManage=home.clickManageNewsInfo();
		String news="Breaking News";
		//ManageNewsPage newsManage=new ManageNewsPage(driver);
		newsManage.clickNewsSeach().searchNewsTitle(news).seachSubmit();
			
	}
	@Test
	public void resetNewsAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		newsManage=home.clickManageNewsInfo();
		//ManageNewsPage newsManage=new ManageNewsPage(driver);
		newsManage.resetNews();
	}
}

