package co.in.edureka.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import co.in.edureka.basics.BasePage;

public class ProfilePage extends BasePage {

	@FindBy(xpath ="//li[@class='dropdown user_drop']") WebElement profileIcon;
	
	@FindBy (xpath ="//a[@href ='/my-profile']")WebElement MyProfile;
	
	@FindBy(xpath ="//*[@id=\"professional_details\"]")WebElement editProfDetails;
	
	@FindBy(xpath ="//*[@id=\"collapseOne\"]/div/div/form/button")WebElement continuBtn;
	
	@FindBy (name = "companyName")WebElement companyName;
	
	@FindBy(name = "currentjob")WebElement currentJob;
	
	@FindBy(name = "currentIndustry")WebElement currentIndustry;
	
	@FindBy(name = "linkedinLink")WebElement linkedinLink;
	
	@FindBy(name = "userSkill")	WebElement userSkill;
	
	@FindBy(xpath = "//*[@id=\"onboarding\"]/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/accordion/accordion-group/div/div[2]/div/form/button[2]")
	WebElement nextBtn;
	
	public ProfilePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyProfile() {
		try
		{
			verifyElement(profileIcon);
			profileIcon.click();
			verifyElement(MyProfile);
			MyProfile.click();
			log.info("User chose My Profile from the drop down.");
		}
		catch(Exception e)
		{
			log.error("Error while clicking on My Profile");
		}
	}
	
	public void editPersonalDetails()
	{
		try
		{
			verifyElement(editProfDetails);
			editProfDetails.click();
			log.info("User clicked on Edit Professional Details");
		}
		catch(Exception e)
		{
			log.error("Error while clicking on Edit Professional Details");
		}
	}
	
	public void enterProfDetails(String company, String industry, String job, String linkedIn, String skills)
	{
		verifyElement(companyName);
		verifyElement(currentIndustry);
		verifyElement(currentJob);
		verifyElement(linkedinLink);
		verifyElement(userSkill);
		
		companyName.clear();
		companyName.sendKeys(company);
		
		Select seljob = new Select(currentJob);
		seljob.selectByVisibleText(job);
		
		Select selindustry = new Select(currentIndustry);
		selindustry.selectByVisibleText(industry);
		
		linkedinLink.clear();
		linkedinLink.sendKeys(linkedIn);
		
		userSkill.clear();
		userSkill.sendKeys(skills);
		
		nextBtn.click();
	}
}
