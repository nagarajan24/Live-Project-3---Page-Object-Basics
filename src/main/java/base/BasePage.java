package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import extentlisteners.ExtentListener;
import utilities.CustomAssertUtil;
import utilities.ExcelReader;

public class BasePage {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static TopMenu menu;
	
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public FileInputStream fis;
	public String browser;
	public WebElement dropdown;
	public static Logger log = Logger.getLogger(BasePage.class);
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static CustomAssertUtil asrt = new CustomAssertUtil();
	
	//Closing the browsers
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	//Keywords
	public static void click(String key)
	{
		if(key.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(key))).click();
		}
		else if(key.endsWith("_LINKTEXT"))
		{
			driver.findElement(By.linkText(OR.getProperty(key))).click();
		}
		
		log.info("Element: "+key+" is clicked successfully");
		ExtentListener.test.info("Element: "+key+" is clicked successfully");
	}
	
	public void type(String key, String value)
	{
		if(key.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}
		else if(key.endsWith("_ID"))
		{
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		
		log.info("Text: "+value+" is Entered successfully in : "+key);
		ExtentListener.test.info("Text: "+value+" is Entered successfully in : "+key);
	}
	
	public void select(String key, String value)
	{
		if(key.endsWith("_CSS"))
		{
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(key)));
		}
		else if(key.endsWith("_XPATH"))
		{
			dropdown = driver.findElement(By.xpath(OR.getProperty(key)));
		}
		else if(key.endsWith("_ID"))
		{
			dropdown = driver.findElement(By.id(OR.getProperty(key)));
		}
		
		Select s = new Select(dropdown);
		s.selectByVisibleText(value);
		
		log.info("Value: "+value+" is selected successfully in the "+key+" dropdown");
		ExtentListener.test.info("Value: "+value+" is selected successfully in the "+key+" dropdown");
	}
	
	
	public boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			log.info("Element is present");
			ExtentListener.test.info("Element is present");
			return true;
		}
		catch(NoSuchElementException e){
			log.info("Element is not present. Exception msg: "+e);
			ExtentListener.test.info("Element is not present. Exception msg: "+e);
			return false;
		}
	}
	
	public void waitWithSendKeys(String key, String value)
	{
		if(key.endsWith("_CSS"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(key)))).sendKeys(value);
		}
		else if(key.endsWith("_XPATH"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(key)))).sendKeys(value);
		}
		else if(key.endsWith("_ID"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(key)))).sendKeys(value);
		}
		
		log.info("Text: "+value+" is Entered successfully in : "+key);
		ExtentListener.test.info("Text: "+value+" is Entered successfully in : "+key);
	}
	
	public void waitWithClick(String key)
	{
		if(key.endsWith("_CSS"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(OR.getProperty(key)))).click();
		}
		else if(key.endsWith("_XPATH"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(key)))).click();
		}
		else if(key.endsWith("_ID"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(OR.getProperty(key)))).click();
		}
		
		log.info(key+" is clicked successfully");
		ExtentListener.test.info(key+" is clicked successfully");
	}
	
	
	public BasePage()
	{
		if(driver == null) {
			
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			log.info("OR and Config property files are loaded successfully");
//			ExtentListener.test.info("OR and Config property files are loaded successfully");
			
			//Code for Jenkins Browser selection
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty())
			{
				browser = System.getenv("browser");
			}
			else
			{
				browser = Config.getProperty("browser");
			}
			
			Config.setProperty("browser", browser);
			
			
			//Browser configuration
			if(browser.equalsIgnoreCase("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				driver = new ChromeDriver(options);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			
			log.info("Browser: "+browser+" is launched successfully");
//			ExtentListener.test.info("Browser: "+browser+" is launched successfully");
			driver.get(Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicit.wait"))));
			
			menu = new TopMenu(driver);
		
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Config.getProperty("explicit.wait"))));
			
		}
	}

}
