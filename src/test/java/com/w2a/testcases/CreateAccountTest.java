package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.ZohoAppPage;
import pages.crm.accounts.AccountsHomePage;
import pages.crm.accounts.CreateAccountPage;
import utilities.DataUtil;

public class CreateAccountTest {
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String,String> data)
	{
		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		
		AccountsHomePage ahp = BasePage.menu.goToAccount();
		ahp.verifyAccountsHomePage();
		CreateAccountPage cap = ahp.createAccount();
		cap.createAnAccount(data.get("accountname"));
		
		Assert.fail("Failing Account Test");
		
	}

}
