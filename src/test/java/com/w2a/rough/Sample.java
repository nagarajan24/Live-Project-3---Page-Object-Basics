package com.w2a.rough;

import base.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import pages.crm.accounts.AccountsHomePage;
import pages.crm.accounts.CreateAccountPage;

public class Sample{
	
	
	public static void main(String[] args) {
			
		
//		zp.goToCRM();
		
		AccountsHomePage ahp = BasePage.menu.goToAccount();
		ahp.verifyAccountsHomePage();
		CreateAccountPage cap = ahp.createAccount();
		cap.createAnAccount("Naga");
	}

}
