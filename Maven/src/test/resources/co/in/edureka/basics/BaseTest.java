package co.in.edureka.basics;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConst {

	public static WebDriver driver = null;
	public WebDriverWait wait = null;
	public Logger log = Logger.getLogger(BaseTest.class);

	@Parameters({"browser"})
	
	@BeforeMethod
	public void launchBrowser(String browser)
	{
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
		try
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty(chrome_key, chrome_value);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(URL);
				log.info("User Selected Chrome as Browser");
				Reporter.log("User Selected Chrome as Browser");
			}
			else
			{
				log.error("Invalid Selection");
			}
		}
		catch(Exception e)
		{
			Reporter.log("Invalid selection" +e);
		}
	}

	
	  @AfterMethod 
	  public void closeBrowser() 
	  { 
		  driver.quit(); 
	  }
	 
  
}
 
