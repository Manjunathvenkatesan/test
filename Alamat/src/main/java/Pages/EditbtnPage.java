package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditbtnPage {
	
	@FindBy(xpath="//a[.='Potentials' and @class='menuOff']")
	private WebElement potmod;
	
    public WebElement getPot() {
    	return potmod;
    }
    public void setPot()
    {
    	potmod.click();
    }
    @FindBy(xpath="//a[@class='link' and .='shiva' ]")
    private WebElement plead;
  
    public WebElement getLead() 
    {
	  return plead;
    }
    public void setLead() 
    {
	  plead.click();
    }
    @FindBy(xpath="//input[@name='edit2']")private WebElement editbtn;
    public WebElement getEdit()
    {
	  return editbtn;
    }
    public void setEdit()
    {
	  editbtn.click();
    }	
    public EditbtnPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }


}
