package com.w2a.base;

import org.testng.annotations.AfterSuite;

import base.BasePage;

public class BaseTest {
	
	@AfterSuite
	public void tearDown()
	{
		BasePage.closeBrowser();
	}

}
