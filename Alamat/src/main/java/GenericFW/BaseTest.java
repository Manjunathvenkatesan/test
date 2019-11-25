package GenericFW;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Pages.AlamatSignin;

public class BaseTest implements IAutoCommon{
	public static WebDriver driver;
	
	FileGenericMethods file;
	 
	WebdriverCommonMtds wdlib;
	
	AlamatSignin al;
	
	@BeforeClass  
	public void openBrowser() throws Throwable {
		
		file=new FileGenericMethods();
		wdlib=new WebdriverCommonMtds();
		
		String browservalue=file.getProValue(PROPERTY_PATH, "browser");
		if (browservalue.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		}
		else if (browservalue.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else {
			Reporter.log("enter valid browser",true);
		}
		
		driver.get(file.getProValue(PROPERTY_PATH, "url"));
		Reporter.log(driver.getTitle(), true);
		String expect = file.getCellData(EXCELL_PATH, "Sheet1", 1, 4);
		wdlib.verifyAssert(wdlib.getPageTitle(), expect, "login page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable {
		
		Thread.sleep(2000);
		
		file=new FileGenericMethods();
		String lgname = file.getProValue(PROPERTY_PATH, "LoginName");
		String password = file.getProValue(PROPERTY_PATH, "Password");
		
		al=new AlamatSignin(driver);
		al.login(lgname, password);
		
		Thread.sleep(2000);
		wdlib=new WebdriverCommonMtds();
		String expect = file.getCellData(EXCELL_PATH, "Sheet1", 1, 5);
		wdlib.verifyAssert(wdlib.getPageTitle(), expect, "home page");
		
		
	}
	
	
	@AfterMethod
	public void logOutToApp() {
		
		al=new AlamatSignin(driver);
		al.clickLogOutLink();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
