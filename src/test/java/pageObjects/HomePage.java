package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) 
	{
		super(driver); // when u want to get parent class constructor then we use super keyword

	}
	@FindBy(xpath="//span[text()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//a[text()='Register']") WebElement linkMyResgister;
	@FindBy(xpath="//a[text()='Login']") WebElement myLogin;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickMyRegister()
	{
		linkMyResgister.click();
		
	}
	
	public void clickLogin() 
	{
		myLogin.click();
	}

	
}
