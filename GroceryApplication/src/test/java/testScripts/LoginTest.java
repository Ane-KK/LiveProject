package testScripts;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import base.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utitilities.ExcelUtility;

public class LoginTest extends Base
{
	
	HomePage home;
@Test(priority=1,description="Verifying user login with valid credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		boolean isdasboardDisplayd = loginpage.dashboardDisplay();
		Assert.assertTrue(isdasboardDisplayd,Constants.ValidCredentialError);
	}
@Test(priority=2)
	public  void verifyLoginValidUsernameInvalidPassword() throws IOException 
	{
		String usernamevalue=ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue).loginButtonClick();
		String actual=loginpage.textDisplay();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was unable to login with invalid credential");
	}
@Test(priority=3)
	public void verifyInvalidUsernameValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(2, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue).loginButtonClick();
	}
@Test(priority=4,groups= {"smoke"},dataProvider = "loginProvider")
   public void verifyInvalidUsernameInvalidPassword(String usernamevalue, String passwordvalue) throws IOException 
   {
	   //String usernamevalue=ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordvalue=ExcelUtility.readStringData(3, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue).loginButtonClick();
	
   }

@DataProvider(name = "loginProvider")
public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
			// new Object[] {ExcelUtility.getStringData(3,
			// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};

}
}