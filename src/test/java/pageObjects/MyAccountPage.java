package pageObjects;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading; //Myaccountpage heading
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']") WebElement btnLogout; //added in step 6
	
	public boolean isMyAccountPageExsist()
	{
		try 
		{
		return msgHeading.isDisplayed();
		}
		
	catch(Exception e)
	{
		return false;
	}
	}
	
	public void ClickLogout()
	{
		btnLogout.click();
	}
	
}
