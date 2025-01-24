package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='E-Mail Address']")
	WebElement SetEmail;
	
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	WebElement SetPassword;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement Loginbtn; 
	
	public void Email(String getEMail) {
		SetEmail.sendKeys(getEMail);
	}
	
	public void Password(String getPassword) {
		SetPassword.sendKeys(getPassword);
	}
	
	public void ClickLogin() {
		Loginbtn.click();
	}

}
