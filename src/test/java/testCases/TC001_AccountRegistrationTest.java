package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"regression","master"})
	public void verify_account_registration()
	{
		logger.info("****StartingTC001_AccountRegistrationTest ****" );
		try
		{
		HomePage hp= new HomePage(driver);	
		hp.clickMyAccount();
		logger.info("Clicked on My account" );
		
		hp.clickMyRegister();
		logger.info("Clicked on My Register" );
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("providing Customer details" );	
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		regpage.setTelephone(randomNumber());
		
		String pwd = randomAlphaNumeric();
		
		regpage.setPassword(pwd);
		regpage.setConfirmPassword(pwd);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		

		logger.info("Validating expected message" );	
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			
			Assert.assertTrue(true);
			
		}
		
		else
		{
			logger.error("Test failed....");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("****Finished  TC001_AccountRegistrationTest ****" );
				
	}
	
	
	
	
	

}
