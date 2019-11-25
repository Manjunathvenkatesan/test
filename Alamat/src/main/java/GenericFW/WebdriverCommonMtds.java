package GenericFW;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WebdriverCommonMtds extends BaseTest {
	
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
	public void waitForPageLoad( String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void waitForVisibiltyElements(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void selectOption(WebElement element,String text ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectOption(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectOption(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void mouseOver(WebElement target) {
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
	}
	
	
	public void verifyAssert(String actual,String expected,String message) {
		Assert.assertEquals(actual, expected);
		Reporter.log(message+" verified test passed", true);
	}
	
	

}
