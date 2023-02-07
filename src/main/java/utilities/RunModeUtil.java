package utilities;

import base.BasePage;

public class RunModeUtil extends BasePage{
	
	
	public static boolean isTestRunnable(String testName)
	{
		String sheetName= "test_suite";
		int rows = excel.getRowCount(sheetName); 
		for(int row=2;row<=rows;row++)
		{
			String testcase = excel.getCellData(sheetName, "TCID", row);
			if(testcase.equalsIgnoreCase(testName))
			{
				String runMode = excel.getCellData(sheetName, "runmode", row);
				if(runMode.equalsIgnoreCase("Y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}

}
