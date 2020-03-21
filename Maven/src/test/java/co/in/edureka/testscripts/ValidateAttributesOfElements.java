package co.in.edureka.testscripts;
import org.testng.Reporter;
import org.testng.annotations.Test;

import co.in.edureka.basics.BaseTest;
import co.in.edureka.pompages.HomePage;

public class ValidateAttributesOfElements extends BaseTest
{
	public HomePage homepage = null;
	
	@Test
	public void attributesOfSearchTxtBox()
	{		
		try
		{
			homepage = new HomePage(driver);
			homepage.attributesOfanSearchText();
			
			Reporter.log("Attributes printed successfully.", true);
		}
		catch(Exception e)
		{
			Reporter.log("Attributes could not be printed.", true);
		}
	}
}
