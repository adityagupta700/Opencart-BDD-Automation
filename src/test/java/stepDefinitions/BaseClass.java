package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomersPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.PropertyFileHandler;

public class BaseClass {

	public WebDriver driver;

	public LoginPage lp;
	public DashboardPage dp;
	public CustomersPage cp;

	public PropertyFileHandler configFileHandler;
	public PropertyFileHandler customerFileHandler;
	public static Logger logger;

	public void initializePageObjects() {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		cp = new CustomersPage(driver);
	}

	public String getFullName() throws IOException {
		String firstName = customerFileHandler.readProperty("firstName");
		String lastName = customerFileHandler.readProperty("lastName");

		String fullName = firstName + " " + lastName;

		return fullName;
	}
}
