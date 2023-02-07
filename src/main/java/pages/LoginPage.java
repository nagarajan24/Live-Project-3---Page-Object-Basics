package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;




public class LoginPage extends BasePage{
	
	
	public ZohoAppPage doLogin(String userName, String password)
	{
		
		System.out.println(OR.getProperty("loginBtn_XPATH"));
		type("loginBtn_XPATH",userName);
		click("loginNextBtn_XPATH");
		waitWithSendKeys("pwd_CSS", password);
		click("pwdNextBtn_CSS");
		
		return new ZohoAppPage();
		
	}

}
