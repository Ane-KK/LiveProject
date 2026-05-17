package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import utitilities.ExcelUtility;

public class HomeTest extends Base

{
	@Test
	public void verifyUserLogoutAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.clickAdmin();
		home.clickLogout();
	}
	
	

}
