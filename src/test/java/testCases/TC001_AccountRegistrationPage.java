package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationPage extends BaseClass{

	@Test(groups= {"Sanity", "Master"})
	public void AccountRegPag() throws InterruptedException {
		try {
			HomePage HP = new HomePage(driver);
			HP.clickMyAccount();
			logger.info("***Account Button Clicked Successfully***");
			HP.clickRegister();
			logger.info("***Register Button Clicked Successfully***");
			RegisterPage RP = new RegisterPage(driver);
			logger.info("***Entering Customer Details***");
			RP.SetFName(randomString().toUpperCase());
			RP.SetLName(randomString().toUpperCase());
			RP.SetEMail(randomString()+"@gmail.com");
			String Password = randomalphanum();
			RP.SetTelephone("23456789");
			RP.SetPassword(Password);
			RP.SetConfirmPassword(Password);
			
			RP.SetRadioBtn();
			RP.SetCheckbx();
			RP.SetContinue();
			String GMsg = RP.GetMsgConfirmation();
			if(GMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
			logger.error("Error Occured");
			logger.debug("This is Debugg Process");
			Assert.assertTrue(false);
			}
		} 
		catch (Exception e) {
			Assert.fail();
		}
		
	}
		
}
