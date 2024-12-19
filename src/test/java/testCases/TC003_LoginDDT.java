package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="datadrivern") // getting data provider from different
																				// class
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("******starting TC003_LoginDDT******");
		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean target_page = macc.isMyAccountPageExsist();

			/*
			 * Data is valid = login success- logout data is valid - login failed - test
			 * fail
			 * 
			 * Data is invalid - login success - test failed - log out data is invalid -
			 * login failed - test pass
			 */

			if (exp.equalsIgnoreCase("valid")) {
				if (target_page == true) {
					macc.ClickLogout();
					Assert.assertTrue(true);

				}

				else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("invalid")) {

				if (target_page == true) {
					macc.ClickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("******finished TC003_LoginDDT******");
	}

}
