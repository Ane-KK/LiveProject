package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utitilities.ExcelUtility;

public class AdminUserTest extends Base{
	
	@Test
	public void verifyNewUserCreationAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
		HomePage home= new HomePage(driver);
		//home.clickAdmin();
		home.clickAdminUserMoreInfo();
		
		
		String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		String userpassword=ExcelUtility.readStringData(0, 0, "HomePage");
		AdminUserPage admin=new AdminUserPage(driver);
		admin.newUserbutton();
		admin.enterUsernameInUsernanefield(newuser);
		admin.enterPasswordInPasswordfield(userpassword);
		admin.selectUserType();
		admin.saveClick();
		
		//home.clickLogout();
	}
	
	@Test
	public void VerifyUserSearchAfterUserCreation() throws IOException
	{
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.clickAdminUserMoreInfo();
		
		String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		AdminUserPage admin=new AdminUserPage(driver);
		admin.searchUser();
		admin.searchname(newuser);
		admin.searchUserType();
		admin.searchUserButton();
	}
	@Test
	public void resetUserAfterSearch() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		loginpage.loginButtonClick();
		HomePage home= new HomePage(driver);
		home.clickAdminUserMoreInfo();
		
		String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		AdminUserPage admin=new AdminUserPage(driver);
		admin.searchUser();
		admin.searchname(newuser);
		admin.searchUserType();
		admin.searchUserButton();
		admin.resetUser();
	}

	
}
