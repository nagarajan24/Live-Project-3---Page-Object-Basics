package utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import base.BasePage;

public class DataUtil extends BasePage{
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][1];
		Hashtable<String,String> table;
		
		for(int row=2;row<=rows;row++)
		{
			table = new Hashtable<String,String>();
			for(int col=0;col<cols;col++)
			{
				table.put(excel.getCellData(sheetName, col, 1),excel.getCellData(sheetName, col, row));
				data[row-2][0] = table; 
			}
		}
		
		return data;
	}

}
