package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginPage extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void VerifyLogin() {
		try {    
			logger.info("*** TC002 execution started ***");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.ClickLogin();
			logger.info("** Login Page Opened Successfully **");
			
			LoginPage lp = new LoginPage(driver);
			lp.Email(p.getProperty("Username"));
			lp.Password(p.getProperty("Password"));
			lp.ClickLogin();
			
			logger.info("** My Account Page Opened Successfully **");
			
			MyAccountPage myacc = new MyAccountPage(driver);
			boolean Myacc = myacc.VerifyMyAccount();
			Assert.assertTrue(Myacc);
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC002 Execution ***");
	}
	
}
