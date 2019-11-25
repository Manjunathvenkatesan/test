package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPotential {

	@FindBy(xpath="//input[@onclick='createAction()']")
	private WebElement newbtn;

	public WebElement getNewbtn() {
		return newbtn;
	}

	public void clickOnNewbtn() {
	
		newbtn.click();
	}

	public NewPotential(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
