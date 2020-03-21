package co.in.edureka.basics;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class ITest implements ITestListener {


	public void onTestStart(ITestResult result) {

		
	}


	public void onTestSuccess(ITestResult result) {
	
		String name = result.getMethod().getMethodName();
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		try {
			File src = event.getScreenshotAs(OutputType.FILE) ;
			FileHandler.copy(src, new File("./Screenshots/Pass/"+name+".jpg"));
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void onTestFailure(ITestResult result) 
	{
		String name = result.getMethod().getMethodName();
		EventFiringWebDriver event =  new EventFiringWebDriver(BaseTest.driver);
		try
		{
			File src =  event.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshots/Fail"+name+".jpg"));
		}
		catch(Exception e)
		{
			Reporter.log("Exception taking screenshot: "+e);
		}
	}


	public void onTestSkipped(ITestResult result) {
	
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}


	public void onStart(ITestContext context) {
	
		
	}


	public void onFinish(ITestContext context) {
	
		
	}

}
