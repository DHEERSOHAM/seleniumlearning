package listners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserfactory.BrowserFactory;
import helper.utility;


public class ExtentTestNGITestListener implements ITestListener {
	
	ExtentReports extent= ExtentManager.getInstance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(extentTest);
	}
	public void onTestSuccess(ITestResult result)
	{
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String base64 = utility.capturescreenshotinBase64(driver);
		
		parentTest.get().pass("test passed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	public void onTestFailure(ITestResult result)
	{
		WebDriver driver =BrowserFactory.getBrowserInstance();
		String base64 = utility.capturescreenshotinBase64(driver);
		parentTest.get().fail("test failed" + result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	public void onTestSkipped(ITestResult result)
	{
		WebDriver driver = BrowserFactory.getBrowserInstance();
		String base64 = utility.capturescreenshotinBase64(driver);
		parentTest.get().skip("test skipped" + result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
