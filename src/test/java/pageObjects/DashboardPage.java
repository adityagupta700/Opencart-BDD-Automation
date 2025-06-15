package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@id='button-menu']//following-sibling::ul/li[2]/a")
	WebElement logutButton;
	
	@FindBy(xpath = "//li[@id='menu-customer']/a")
	WebElement customerDropDownLink;
	
	@FindBy(xpath = "//li[@id='menu-customer']//a[text()='Customers']")
	WebElement customersLink;
	
	public void clickOnLogoutBtn() {
		logutButton.click();
	}
	
	public void clickCustomerDropDown() {
		customerDropDownLink.click();
	}
	
	public void clickCustomers() {
		customersLink.click();
	}
}
