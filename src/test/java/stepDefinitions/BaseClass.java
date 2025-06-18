package stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.javafaker.Faker;

import io.cucumber.java.Before;
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
	public PropertyFileHandler configFileHandler;
	public PropertyFileHandler customerFileHandler;
	public static Logger logger;

	@Before
	public void setup() throws IOException {
		String rootPath = System.getProperty("user.dir");

		configFileHandler = new PropertyFileHandler("config.properties");

		
		String browser = configFileHandler.readProperty("browser");
		
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver." + browser + ".driver", rootPath + configFileHandler.readProperty("chromedriverpath"));
			driver = new ChromeDriver();
		
		}else if(browser.equals("edge")) {
			
			System.setProperty("webdriver." + browser + ".driver", rootPath + configFileHandler.readProperty("edgedriverpath"));
			driver = new EdgeDriver();
		
		}
		
		logger = Logger.getLogger("opencart");
		PropertyConfigurator.configure("log4j.properties");

		// customers feature => property file
		customerFileHandler = new PropertyFileHandler(rootPath + "/test-data/customerData.properties");
	}

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
