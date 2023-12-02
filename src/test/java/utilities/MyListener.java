package utilities;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class MyListener implements ITestListener {
	
	ScreenshotUtility s;
	ExtentReports e;
	ExtentTest t;
	
public void onTestStart(ITestResult result) {
		
		System.out.println("Test method has been started");
		t.log(LogStatus.INFO,result.getMethod().getMethodName()+ "has started");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		System.out.println("Test method is success");
		try
		{
			t.log(LogStatus.PASS,"Screenshot"+t.addScreenCapture(s.takeScreenshot()));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
	
		
		System.out.println("Test method is failure");
	try
	{
		t.log(LogStatus.FAIL,"Screenshot"+t.addScreenCapture(s.takeScreenshot()));
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method is sipped");
		t.log(LogStatus.SKIP,result.getMethod().getMethodName()+ "has skipped");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test method is failure due to timeout");
		
	}

	public void onStart(ITestContext context) {
		
		s=new ScreenshotUtility();
		System.out.println("Testing has started");
		e=new ExtentReports("test-output\\myreport.html");
		t=e.startTest("login has started");
		
		e.addSystemInfo("Browser", "Chrome");
		e.addSystemInfo("Build", "Smoke Testing");
		
		}

	public void onFinish(ITestContext context) {
		
		System.out.println("Testing has ended");
		e.endTest(t);
		e.flush();
	}

	
	

}
