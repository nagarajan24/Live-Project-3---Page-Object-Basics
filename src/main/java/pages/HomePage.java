package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class HomePage extends BasePage{
	
	
	public void goToCustomer()
	{
		driver.findElement(By.cssSelector("a[class='zh-customers']")).click();	
	
	}
	
	public void goToSupport()
	{
		driver.findElement(By.className("a[class='zh-support']")).click();
	}
	
	public LoginPage goToSignIn()
	{
		click("signin_LINKTEXT");
		return new LoginPage();
	}
	
	public void goToFooter()
	{
		driver.findElements(By.xpath("//div[@class='footer-sec-wrap']"));
	}

}
