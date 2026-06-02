package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utitilities.ExcelUtility;
import utitilities.FakerUtility;

public class AdminUserTest extends Base{
	
	AdminUserPage admin;
	HomePage home;
	
	@Test
	public void verifyNewUserCreationAfterSuccesfullLogin() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		//home.clickAdmin();
		admin=home.clickAdminUserMoreInfo();
		
		
		//String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		//String userpassword=ExcelUtility.readStringData(0, 0, "HomePage");
		
		FakerUtility faker=new FakerUtility();
		String newuser=faker.createRandomUserName();
		String userpassword=faker.createRandomPassword();
		
		//AdminUserPage admin=new AdminUserPage(driver);
		admin.newUserbutton().enterUsernameInUsernanefield(newuser).enterPasswordInPasswordfield(userpassword).selectUserType().saveClick();
			
		//home.clickLogout();
	}
	
	@Test
	public void verifyUserSearchAfterUserCreation() throws IOException
	{
		
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue).enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		admin=home.clickAdminUserMoreInfo();
		
		String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		//AdminUserPage admin=new AdminUserPage(driver);
		admin.searchUser().searchname(newuser).searchUserType().searchUserButton();
				
	}
	@Test
	public void resetUserAfterSearch() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameInUsernanefield(usernamevalue);
		loginpage.enterPasswordInPasswordfield(passwordvalue);
		home=loginpage.loginButtonClick();
		//HomePage home= new HomePage(driver);
		admin=home.clickAdminUserMoreInfo();
		
		String newuser=ExcelUtility.readStringData(0, 0, "HomePage");
		//AdminUserPage admin=new AdminUserPage(driver);
		admin.searchUser().searchname(newuser).searchUserType().searchUserButton().resetUser();
			
	}

	
}
