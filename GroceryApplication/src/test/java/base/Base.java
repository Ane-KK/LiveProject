package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utitilities.ScreenshotUtility;


public class Base {
	
	Properties prop;
	FileInputStream fs;
	
	public WebDriver driver;
	
	@Parameters("browsers")
	@BeforeMethod(alwaysRun=true)

	public void browserLaunch(String browsers) throws Exception
	{
		prop=new Properties();
		fs=new FileInputStream(Constants.ConfigFile);
		prop.load(fs);
		
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("Invalid Browser");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit wait
	}
	@AfterMethod(alwaysRun=true)
	/*public void browserCloseAndQuit()
	{
		//driver.close();
		driver.quit();
	}*/
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 		driver.quit(); 
  
 	}
}


