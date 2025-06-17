package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class BasePage {
	public WebDriver driver;
	public WaitHelper waithelper;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		waithelper = new WaitHelper(this.driver);
	}
}
