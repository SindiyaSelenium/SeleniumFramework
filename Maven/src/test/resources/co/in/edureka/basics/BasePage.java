package co.in.edureka.basics;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void verifyElement(WebElement ele)
	{
			WebDriverWait wait = new WebDriverWait(driver,30);
			try
			{
				wait.until(ExpectedConditions.visibilityOf(ele));
				log.info(ele +" element present");
				
			}
			catch(Exception e)
			{
				log.error(ele +" element not present");
			}
	}
	
	public void verifyElementAttribute(WebElement ele)
	{
		try
		{
			log.info("Class of the element "+ele+ " is: "+ele.getAttribute("value"));
			log.info("Class name is: "+ele.getClass());
			log.info("Name is: "+ele.getAttribute("name"));
			log.info("Class is: "+ele.getAttribute("className"));
			log.info("CSS Value is: "+ele.getAttribute("cssValue"));
			log.info("Xpath Value: "+ele.getAttribute("xpath"));
			log.info("Id is: "+ele.getAttribute("id"));
		}
		catch(Exception e)
		{
			log.info("Could not capture the element attributes.");
			
		}
	}
	
	public void verifyTitle(String exp_Title)
	{
		String act_title =  driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.titleIs(exp_Title));
			act_title = driver.getTitle();
			System.out.println(act_title);
			Assert.assertTrue(act_title.equals(exp_Title));
			log.info("Expected Title: "+exp_Title+ " matches Actual Title: "+act_title);
			Reporter.log("Expected Title: "+exp_Title+ " matches Actual Title: "+act_title);
		}
		catch(Exception e)
		{
			log.error("Expected Title: "+exp_Title+ " DOES NOT match Actual Title: "+act_title);
			Reporter.log("Error while capturing titles");
			log.error("Error while capturing titles");
		}
	}
	
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		try 
		{
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(ele));
		action.moveToElement(ele).perform();
		log.info("Mouse hovered to Element" +ele);
		}
		catch(Exception e)
		{
			log.error("Element not found for mouse hover");
		}		
	}
	
	public void navigateBack(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			driver.navigate().back();
			wait.until(ExpectedConditions.titleIs(title));
			log.info("The page title is: ");
		}
		catch(Exception e)
		{
			log.error("Unable to load page.");
		}
	}
	
}
