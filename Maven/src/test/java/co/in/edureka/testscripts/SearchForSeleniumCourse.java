package co.in.edureka.testscripts;
import org.testng.Reporter;
import org.testng.annotations.Test;

import co.in.edureka.basics.BaseTest;
import co.in.edureka.pompages.CoursePage;
import co.in.edureka.pompages.HomePage;

public class SearchForSeleniumCourse extends BaseTest 
{

	public static HomePage homepage = null;
	public static CoursePage coursepage = null;
	public String course = "selenium";
	public String exp_Title = "WebDriver Online Training";
	
	@Test
	public void TC_01_SearchForACourse()
	{
		homepage = new HomePage(driver);
		coursepage = new CoursePage(driver);
		
		homepage.searchACourse(course);
		Reporter.log("User Searched for Course: "+course);
		homepage.verifyTitle(exp_Title);
		
		coursepage.selectSeleniumCourse(course);
		//log.info("Title of the page is: "+driver.getTitle());
		Reporter.log(driver.getTitle());		
		driver.navigate().back();
		//log.info("Title of the page is: "+driver.getTitle());
		Reporter.log(driver.getTitle());
	}

	
	
}
