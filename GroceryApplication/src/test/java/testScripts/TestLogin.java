package testScripts;

import pages.Basepage;
import pages.LoginPage;
import utilities.ExcelUtilies;

public class TestLogin extends Basepage
{

	public void verifyUserLoginWithValidCredentials()
	{
		String usernamevalue=ExcelUtilies.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtilies.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
	}
}
