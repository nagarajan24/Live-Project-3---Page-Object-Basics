package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.BaseTest;

import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;
import utilities.DataUtil;

public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data)
	{	
		HomePage home = new HomePage();
		LoginPage login = home.goToSignIn();
		login.doLogin(data.get("username"),data.get("password"));
		
		Assert.fail("Failing Login Test");
	}

}
