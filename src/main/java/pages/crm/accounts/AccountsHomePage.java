package pages.crm.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class AccountsHomePage extends BasePage{
	
	
	public AccountsHomePage verifyAccountsHomePage()
	{
		driver.findElement(By.xpath("(//button[contains(@class,'lyte-butto')])[1]"));
		return this;
	}
	
	public CreateAccountPage createAccount()
	{
		waitWithClick("createAccountBtn_XPATH");
		return new CreateAccountPage();
	}

}
