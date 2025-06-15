package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

public class CustomersPage extends BasePage{
	
	Faker faker;
	
	public CustomersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']//a")
	WebElement addCutomerButton;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstnameInputBox;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastnameInputBox;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailInputBox;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement phoneInputBox;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPasswordField;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button")
	WebElement saveButton;
	
	public void clickOnAddCustomerButton() {
		addCutomerButton.click();
	}
	
	public void setUserDetails() throws Exception {
		faker = new Faker();
		
		firstnameInputBox.sendKeys(faker.name().firstName());
		Thread.sleep(1000);
		lastnameInputBox.sendKeys(faker.name().lastName());
		Thread.sleep(1000);
		emailInputBox.sendKeys(faker.internet().safeEmailAddress());
		Thread.sleep(1000);
		phoneInputBox.sendKeys(faker.phoneNumber().toString());
		Thread.sleep(1000);
		
		String password = faker.internet().password();
	
		passwordField.sendKeys(password);
		Thread.sleep(1000);
		confirmPasswordField.sendKeys(password);
		Thread.sleep(1000);
		
	}
	
	public void clickSaveButton() throws Exception{
		saveButton.click();
		Thread.sleep(1000);
	}
}
