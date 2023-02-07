package utilities;

import org.testng.Reporter;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import extentlisteners.ExtentListener;

public class CustomAssertUtil extends SoftAssert{
	
	
	 @Override
	  public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) 
	 {
			ScreenshotUtil.captureScreenshot();
			
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log("<a href= "+ScreenshotUtil.ScrFileName+" target=\"_blank\">Screenshot link</a>");
			Reporter.log("<br>");
			Reporter.log("<a href= "+ScreenshotUtil.ScrFileName+" target=\"_blank\"><img src= "+ ScreenshotUtil.ScrFileName+" width=200 height=200></img></a>");
			
			
			ExtentListener.test.fail("Screenshot of failure", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.ScrFileName).build());
			
			
		 
	 }

}
