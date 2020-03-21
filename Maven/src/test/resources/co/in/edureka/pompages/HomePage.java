package co.in.edureka.pompages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import co.in.edureka.basics.BasePage;

public class HomePage extends BasePage 
{
	@FindBy (id ="search-inp3") WebElement searchTxt;

	@FindBy(id = "search-inp-overlay-new") WebElement overLaySrchTxt;

	@FindBy(xpath ="//span[@class='typeahead__button new_search_typeahead_button']") WebElement srchBtn;

	@FindBy(id = "search-inp-overlay-new") WebElement overLaySrchBtn;

	@FindBy(xpath ="//*[@id=\"header-II\"]/section/nav/div/a[2]") WebElement logIn;

	@FindBy(xpath ="//*[@id=\"header-II\"]/section/nav/div/a[1]") WebElement singIn;

	@FindBy(id ="si_popup_email") WebElement emailID;

	@FindBy(id = "si_popup_passwd") WebElement password;

	@FindBy(xpath ="//*[@id=\"new_sign_up_mode\"]/div/div/div[2]/div[3]/form/button") WebElement logInBtn;



	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void clickOnLogin()
	{
		try
		{
			verifyElement(logIn);
			logIn.click();
			log.info("User clicked on log in button.");
		}
		catch(Exception e)
		{
			log.error("Error on clicking log in button.");
		}
	}

	public void enterEmailPassword(String email, String passwrd)
	{
		try
		{
			verifyElement(emailID);
			emailID.clear();
			emailID.sendKeys(email);
			verifyElement(password);
			password.sendKeys(passwrd);
			log.info("Uesr eneterd EmaiID and Password successfully.");
			verifyElement(logInBtn);
			logInBtn.click();
			log.info("Log In button clicked successfully");
		}
		catch(Exception e)
		{
			log.error("Error while entering emailID and password");
		}
	}


	public void attributesOfanSearchText()
	{
		try
		{
			verifyElement(searchTxt);
			verifyElementAttribute(searchTxt);
			log.info("The Attributes of Elements are captured.");
		}

		catch(Exception e)
		{
			log.error("Could not capture all the details.");
		}
	}

	public void searchACourse(String course)
	{
		try
		{
			verifyElement(searchTxt);
			searchTxt.click();
			verifyElement(overLaySrchBtn);
			overLaySrchTxt.sendKeys(course+Keys.ENTER);
			//			verifyElement(overLaySrchBtn);
			//			overLaySrchBtn.click();
			log.info("User searched for the course: "+course);		

		}
		catch(Exception e)
		{
			log.error("Unbale to Search for the course.");
		}
	}
}
