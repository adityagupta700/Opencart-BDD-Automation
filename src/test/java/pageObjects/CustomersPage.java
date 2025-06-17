package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends BasePage {

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

	// Search fields
	@FindBy(xpath = "//input[@id = 'input-name']")
	WebElement nameSearchField;

	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement emailSearchField;

	@FindBy(xpath = "//button[@id='button-filter']")
	WebElement filterButton;

	@FindBy(xpath = "//form[@id='form-customer']/table")
	WebElement filteredTable;

	@FindBy(xpath = "//form[@id='form-customer']//tbody/tr")
	List<WebElement> filteredRows;

	@FindBy(xpath = "//form[@id='form-customer']//tbody/tr/td")
	List<WebElement> filteredCells;
	

	public void clickOnAddCustomerButton() {
		addCutomerButton.click();
	}

	public void setFirstname(String fName) {
		firstnameInputBox.sendKeys(fName);

	}

	public void setLastname(String lName) {
		lastnameInputBox.sendKeys(lName);
	}

	public void setEmail(String email) {
		emailInputBox.sendKeys(email);
	}

	public void setPhoneNumber(String phone) {
		phoneInputBox.sendKeys(phone);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void confirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void enterFullnameForFilter(String fullname) {
		waithelper.waitForElement(nameSearchField, 2);
		nameSearchField.sendKeys(fullname);
	}

	public void enterEmailForFilter(String email) {
		waithelper.waitForElement(emailSearchField, 2);
		emailSearchField.sendKeys(email);
	}

	public void pressFilterButton() {
		filterButton.click();
		waithelper.waitForElement(filteredTable, 5);
	}

	public int getRowCount() {
		return filteredRows.size();
	}

	public int getCellCount() {
		return filteredCells.size();
	}

	public List<WebElement> getAllFilteredRows() {
		return filteredRows;
	}

}
