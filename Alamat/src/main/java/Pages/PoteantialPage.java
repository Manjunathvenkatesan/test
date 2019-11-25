package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoteantialPage {
	
	@FindBy(xpath="//a[.='Potentials']")
	private WebElement poteMod;

	public WebElement getPoteMod() {
		return poteMod;
	}

	public void clickOnPoteMod() {
		poteMod.click();
	}

	public PoteantialPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
