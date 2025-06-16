package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import pageObjects.CustomersPage;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;

	public LoginPage lp;
	public DashboardPage dp;
	public CustomersPage cp;

	public Faker faker;

	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		faker = new Faker();
	}
	
	public void initializePageObjects() {
        lp = new LoginPage(driver);
        dp = new DashboardPage(driver);
        cp = new CustomersPage(driver);
    }
}
