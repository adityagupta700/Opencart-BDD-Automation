package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import pageObjects.CustomersPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.PropertyFileHandler;

public class BaseClass {

	public WebDriver driver;

	public LoginPage lp;
	public DashboardPage dp;
	public CustomersPage cp;

	public Faker faker;
	public PropertyFileHandler fileHandler;
	public Logger logger;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		faker = new Faker();
		
		fileHandler = new PropertyFileHandler();
	}
	
	public void initializePageObjects() {
        lp = new LoginPage(driver);
        dp = new DashboardPage(driver);
        cp = new CustomersPage(driver);
    }
	
	public String getFullName() throws IOException {
		String firstName = fileHandler.readProperty("firstName");
		String lastName = fileHandler.readProperty("lastName");
		
		String fullName = firstName + " " + lastName;
		
		return fullName;
	}
}
