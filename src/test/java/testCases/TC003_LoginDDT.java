package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= {"DataDriven"})
	public void LoginDDT(String email, String Pass, String exp) {
		try {
			logger.info("*** TC003 execution started ***");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.ClickLogin();
			logger.info("** Login Page Opened Successfully **");
			
			LoginPage lp = new LoginPage(driver);
			lp.Email(email);
			lp.Password(Pass);
			lp.ClickLogin();
			
			logger.info("** My Account Page Opened Successfully **");
			
			MyAccountPage MyaccPage = new MyAccountPage(driver);
			boolean Myacc = MyaccPage.VerifyMyAccount();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(Myacc==true) {
					MyaccPage.ClickLogout();
					Assert.assertTrue(true);
				}
				else {
					System.out.println("Your credentials is correct(Actual TC Pass), but incorrect exp value in excel file");
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(Myacc==true) {
					System.out.println("Your credentials is incorrect(Actual TC Pass), but incorrect exp value in excel file");
					MyaccPage.ClickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
