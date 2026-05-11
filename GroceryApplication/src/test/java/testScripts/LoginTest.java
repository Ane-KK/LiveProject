package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import utitilities.ExcelUtility;

public class LoginTest extends Base
{
@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
	}
@Test
	public  void verifyLoginValidUsernameInvalidPassword() throws IOException 
	{
		String usernamevalue=ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
	}
@Test
	public void verifyInvalidUsernameValidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(2, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
	}
@Test
   public void verifyInvalidUsernameInvalidPassword() throws IOException 
   {
	   String usernamevalue=ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(3, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
	
   }

}