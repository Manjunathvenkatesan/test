package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintPriviewPage {
	@FindBy(xpath="//input[@name='Print2']")private WebElement prpr;
	  public WebElement getPrintPreview()
	  {
		  return prpr;
	  }
	  public void setPrintPreview()
	  {
		  prpr.click();
	  }
	public PrintPriviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	  
	  

}
