package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-username']")
	WebElement usernameInput;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordInput;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginButton;
	
	public void setUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginButton.click();
	}
}
