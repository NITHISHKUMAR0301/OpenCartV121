package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	WebElement InpFName;
	
	@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
	WebElement InpLName;
	
	@FindBy(xpath = "//input[@placeholder=\"E-Mail\"]")
	WebElement InpEmail;
	
	@FindBy(xpath = "//input[@placeholder=\"Telephone\"]")
	WebElement InpTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement InpPassword;
	
	@FindBy(xpath = "//input[@placeholder=\"Password Confirm\"]")
	WebElement InpCPassword;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement Radiobtn;
	
	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement Checkboxagree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement LoginConfirmation;
	
	public void SetFName(String Fname) {
		InpFName.sendKeys(Fname);
	}
	
	public void SetLName(String Lname) {
		InpLName.sendKeys(Lname);
	}
	
	public void SetEMail(String Email) {
		InpEmail.sendKeys(Email);
	}
	
	public void SetTelephone(String Telephone) {
		InpTelephone.sendKeys(Telephone);
	}
	
	public void SetPassword(String Password) {
		InpPassword.sendKeys(Password);
	}
	public void SetConfirmPassword(String Password) {
		InpCPassword.sendKeys(Password);
	}
	public void SetRadioBtn() {
		Radiobtn.click();;
	}
	public void SetCheckbx() {
		Checkboxagree.click();
	}
	public void SetContinue() {
		btnContinue.click();
	}
	
	public String GetMsgConfirmation() {
		try {
			return(LoginConfirmation.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
	
}
