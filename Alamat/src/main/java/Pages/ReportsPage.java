package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
	
	JavascriptExecutor jse;
	WebDriver driver;
	@FindBy(xpath="//a[.='Reports']")private WebElement repo;
	public WebElement getRepo()
	{
		return repo;
	}
	public void setRepo()
	{
		repo.click();
	}
	@FindBy(xpath="//a[.='Potential Reports']")private WebElement preport;
	public WebElement getPreport()
	{
		return preport;
	}
	public void setPreport() 
	{
		preport.click();
	}
	
	@FindBy(xpath="//a[.='Sales By Lead Source']")private WebElement linkpn;
	
	public WebElement getLinkPotentialAbove()
	{
		return linkpn;
	}
	public void setLinkPotentialAbove() throws InterruptedException
	{   int x=linkpn.getLocation().getX();
	    int y=linkpn.getLocation().getY();
	    jse=(JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy("+x+","+y+")");
	    Thread.sleep(2000);
	    linkpn.click();
	}
	    @FindBy(xpath="//a[.='Potentials by Type']")private WebElement linkpn1;
	    public WebElement getLinkPotential()
	    {
	    	return linkpn1;
	    }
	    public void setLinkPotential() 
	    {
	    	linkpn1.click();
	    }
	    public void clickCrtLink()
	    {   
	    	linkpn.click();
	    	linkpn1.click();
	    }
	
	public ReportsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}



}
