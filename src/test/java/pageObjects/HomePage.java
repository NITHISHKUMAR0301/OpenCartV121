package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement btnMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement btnRegisterPage;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement LoginPage;
	
	public void clickMyAccount() {
		btnMyaccount.click();
	}
	
	public void clickRegister() {
		btnRegisterPage.click();
	}
	
	public void ClickLogin() {
		LoginPage.click();
	}
	
	
}
