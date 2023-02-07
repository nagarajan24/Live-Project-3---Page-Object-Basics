package extentlisteners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.RunModeUtil;
import utilities.ScreenshotUtil;

public class ExtentListener implements ITestListener{

	Date d = new Date();
	String extentFileName = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html"; 
	
	private ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\target\\extentreports\\"+extentFileName);
	public static ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getClass().getName()+"--@--"+result.getMethod().getMethodName());
//		if(!RunModeUtil.isTestRunnable(result.getName()))
//		{
//			throw new SkipException("Run mode of the TC is set as No");
//		}
		
		
	}

	/**
	 * Invoked each time a test succeeds.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS
	 */
	public void onTestSuccess(ITestResult result) {
		test.pass("Test case executed successfully");
	}

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */
	public void onTestFailure(ITestResult result) {
		
		ScreenshotUtil.captureScreenshot();
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href= "+ScreenshotUtil.ScrFileName+" target=\"_blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href= "+ScreenshotUtil.ScrFileName+" target=\"_blank\"><img src= "+ ScreenshotUtil.ScrFileName+" width=200 height=200></img></a>");
		
		
		String expMsg = result.getThrowable().getMessage();
		test.fail(expMsg);
		
		test.fail("Screenshot of failure", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.ScrFileName).build());
		
	}

	/**
	 * Invoked each time a test is skipped.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SKIP
	 */
	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a method fails but has been annotated with
	 * successPercentage and this failure still keeps it within the success
	 * percentage requested.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	/**
	 * Invoked each time a test fails due to a timeout.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 */
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Invoked before running all the test methods belonging to the classes inside
	 * the &lt;test&gt; tag and calling all their Configuration methods.
	 *
	 * @param context The test context
	 */
	public void onStart(ITestContext context) {
		// not implemented
	}

	/**
	 * Invoked after all the test methods belonging to the classes inside the
	 * &lt;test&gt; tag have run and all their Configuration methods have been
	 * called.
	 *
	 * @param context The test context
	 */
	public void onFinish(ITestContext context) {
		if(extent!=null)
		{
			extent.flush();
		}
	}

}
