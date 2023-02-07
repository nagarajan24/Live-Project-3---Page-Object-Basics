package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BasePage;

public class ScreenshotUtil extends BasePage{
	
	public static String ScrFileName;
	
	public static void captureScreenshot()
	{
		Date d = new Date();
		ScrFileName  = d.toString().replace(":", "_").replace(" ","_")+".jpg" ;
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(".\\target\\extentreports\\"+ScrFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
