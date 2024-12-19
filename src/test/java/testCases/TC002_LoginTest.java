package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void verify_login()
	{
		logger.info("*****Starting  TC002_LoginTest Testcase***");
		try 
		{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		
		boolean target_page= macc.isMyAccountPageExsist();
		
		
		Assert.assertTrue(target_page); ////Assert.assertEquals(target_page, true,"Login failed");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("*****finished  TC002_LoginTest Testcase***");
			
		
	}
	
	

}
