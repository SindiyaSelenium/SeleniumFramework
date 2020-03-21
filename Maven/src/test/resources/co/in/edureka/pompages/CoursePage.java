package co.in.edureka.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import co.in.edureka.basics.BasePage;

public class CoursePage extends BasePage {

	@FindBy (xpath ="//*[@id=\"add-master-courses\"]/a[1]")
	WebElement selCourse;
	
	public CoursePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void selectSeleniumCourse(String ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			switch(ele)
			{
				case "selenium":
					wait.until(ExpectedConditions.visibilityOf(selCourse));
					verifyElement(selCourse);
					selCourse.click();
					log.info("User clicked on Selenium Course.");
					wait.until(ExpectedConditions.titleContains("Selenium"));
					break;
			}				
		}
		catch(Exception e)
		{
			log.error("Error while clicking on the course.");
		}
	}
}
