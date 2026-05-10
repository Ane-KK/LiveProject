package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Basepage {
	
	public WebDriver driver;
	

	public void browserLaunch()
	{
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	public void browserCloseAndQuit()
	{
		//driver.close();
		driver.quit();
	}
}


