package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.crm.accounts.AccountsHomePage;

public class TopMenu {
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public AccountsHomePage goToAccount()
	{
		BasePage.click("accountsBtn_LINKTEXT");
		return new AccountsHomePage();
	}
	
	public void goToLeads()
	{
		driver.findElement(By.linkText("Leads")).click();
	}
	
	public void goToServices()
	{
		driver.findElement(By.linkText("Services")).click();
	}
	
	public void goToProjects()
	{
		driver.findElement(By.linkText("Projects")).click();
	}
	
	public void signOut()
	{
		driver.findElement(By.xpath("//*[@id=\"topdivuserphoto_430407000000258001\"]")).click();
		driver.findElement(By.xpath("/html/body/lyte-wormhole/lyte-yield/div/div/lyte-yield/lyte-modal-header/div/div[2]/lyte-button[2]/button/lyte-yield")).click();
	}
	

}
