package pages.crm.accounts;

import org.openqa.selenium.By;

import base.BasePage;

public class CreateAccountPage extends BasePage {

	public void createAnAccount(String accName)
	{
		type("accNameBox_CSS",accName);
	}

}
