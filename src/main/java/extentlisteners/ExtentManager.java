package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName)
	{
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter(fileName);
		
		htmlreporter.config().setEncoding("UTF-8");
		htmlreporter.config().setDocumentTitle("PageObjectModel Project");
		htmlreporter.config().setReportName("PageObject Report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Platform", "Windows");
		extent.setSystemInfo("Model", "Dell");
		extent.setSystemInfo("Tester", "Jack");
		
		return extent;
		
	}

}
