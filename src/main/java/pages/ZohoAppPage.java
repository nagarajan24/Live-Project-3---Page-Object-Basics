package pages;

import org.openqa.selenium.By;

import base.BasePage;
import pages.crm.CRMHomePage;

public class ZohoAppPage extends BasePage{
	
	
	public CRMHomePage goToCRM()
	{
		click("crmBtn_XPATH");
		return new CRMHomePage();
	}
	
	public void goToBooks()
	{
		driver.findElement(By.cssSelector("._logo-books._logo-x64.zod-app-logo")).click();
	}
	
	public void goToInvoice()
	{
		driver.findElement(By.cssSelector("._logo-invoice._logo-x64.zod-app-logo")).click();
	}

}
