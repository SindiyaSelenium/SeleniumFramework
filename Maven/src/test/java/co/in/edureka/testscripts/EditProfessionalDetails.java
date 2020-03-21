package co.in.edureka.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import co.in.edureka.basics.BaseTest;
import co.in.edureka.basics.ReadExcel;
import co.in.edureka.basics.WriteExcelUsingColName;
import co.in.edureka.pompages.HomePage;
import co.in.edureka.pompages.ProfilePage;

public class EditProfessionalDetails extends BaseTest
{
	public HomePage homepage = null;
	public ProfilePage profilepage = null;
	
	@Test
	public void TC_01_EditProfessionalDetails()
	{
		homepage = new HomePage(driver);
		profilepage = new ProfilePage(driver);
		
		try
		{	
			homepage.clickOnLogin();
			Reporter.log("User Clicked on the login Button.");
			String[][] credentials = ReadExcel.getData(InputData, "Sheet1");
			WriteExcelUsingColName write = new WriteExcelUsingColName(InputData);
			
	        
			for(int i=1;i<credentials.length;i++)
			{
				String emailID = credentials[i][0];
				String passwrd = credentials[i][1];
				homepage.enterEmailPassword(emailID, passwrd);
				write.setCellData("Sheet1", "Result", i, "Fail");
				Reporter.log("User Entered the emailID as "+emailID);
			}
			profilepage.clickOnMyProfile();
			profilepage.editPersonalDetails();
			String[][] profdetails = ReadExcel.getData(InputData, "Sheet2");
			for(int i=1;i<profdetails.length;i++)
			{
				String company = profdetails[i][0];
				String industry = profdetails[i][1];
				String job = profdetails[i][2];
				String linkedIn = profdetails[i][3];
				String skills = profdetails[i][4];
				profilepage.enterProfDetails(company, industry, job, linkedIn, skills);
				write.setCellData("Sheet2", "Result", i, "Fail");
				Reporter.log("User chose to edit professional details");
			}
		}
		
		catch(Exception e)
		{
			e.getStackTrace();
			Reporter.log("Error" +e);
		}
	}
	
}
