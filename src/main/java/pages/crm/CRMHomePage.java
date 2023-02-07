package pages.crm;

import org.openqa.selenium.By;

import base.BasePage;

public class CRMHomePage extends BasePage{
	
	
	public void verifyHomePageText()
	{
		driver.findElement(By.xpath("//h1[contains(text(),\"We're happy to have you on board\")]"));
	}
	
	public void verifyZohoCRMTourBtn()
	{
		driver.findElement(By.cssSelector(".lyte-button.ob_starttour.lytePrimaryBtn"));
		
	}

}
