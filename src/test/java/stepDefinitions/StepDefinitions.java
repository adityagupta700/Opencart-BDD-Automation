package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.javafaker.Faker;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.PropertyFileHandler;

public class StepDefinitions extends BaseClass {
	
	@Before
	public void setup() throws IOException {
		String rootPath = System.getProperty("user.dir");

		configFileHandler = new PropertyFileHandler("src/test/resources/config.properties");
		
		String browser = configFileHandler.readProperty("browser");
		
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver." + browser + ".driver", rootPath + configFileHandler.readProperty("chromedriverpath"));
			driver = new ChromeDriver();
		
		}else if(browser.equals("edge")) {
			
			System.setProperty("webdriver." + browser + ".driver", rootPath + configFileHandler.readProperty("edgedriverpath"));
			driver = new EdgeDriver();

		}
		
		logger = Logger.getLogger("opencart");
		PropertyConfigurator.configure("src/test/resources/log4j.properties");

		// customers feature => property file
		customerFileHandler = new PropertyFileHandler(rootPath + "/test-data/customerData.properties");
	}
	
	@After
	public void teardown() {
		logger.info("*************** Closing Browser **************");
		driver.quit();
	}

	@Given("User launches the chrome browser")
	public void launchChromeBrowser() {
		initializePageObjects();
		logger.info("*************** Launching browser **************");
	}

	@And("User opens OpenCart Ecommerce - Admin Application using {string}")
	public void launch_OpenCart_AdminApplication(String url) throws Exception {
		logger.info("*************** Opening Url **************");
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("User enters username as {string} and password as {string}")
	public void setUsername_And_Password(String username, String password) throws Exception {
		lp.setUsername(username);
		Thread.sleep(2000);
		lp.setPassword(password);
		Thread.sleep(2000);
	}

	@And("User clicks on login button")
	public void clickLoginBtn() throws Exception {
		logger.info("*************** Logging In **************");
		
		lp.clickLoginBtn();
		Thread.sleep(3000);
	}

	@Then("Title of the page should be {string}")
	public void checkTitleOfPage(String title) {
		logger.info("*************** Checking Title of the Page **************");
		
		if (driver.getPageSource().contains("No match for Username and/or Password.")
				|| (!title.equals(driver.getTitle()))) {
			driver.quit();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(driver.getTitle(), title);
		}

	}

	@When("User clicks on logout button")
	public void clickOnLogoutButton() throws Exception {
		logger.info("*************** Logging out **************");
		dp.clickOnLogoutBtn();
		Thread.sleep(3000);
	}


	// Add Customers feature step definitions

	@When("User click on Customer DropDown")
	public void clickOnCustomerDropdown() {
		dp.clickCustomerDropDown();
	}

	@And("User clicks on Customers option from dropdown")
	public void clickOnCustomersOptionFromDropdown() {
		dp.clickCustomers();
	}

	@When("User clicks on Add Customer button")
	public void clickOnAddCutomerButton() {
		cp.clickOnAddCustomerButton();
	}

	@And("User enters new customer details")
	public void user_enters_new_customer_details() throws IOException {
		logger.info("*************** Adding  new Customer details **************");
		
		Faker faker = new Faker();
		
		String firstName = faker.name().firstName();
		cp.setFirstname(firstName);

		String lastName = faker.name().lastName();
		cp.setLastname(lastName);

		String email = faker.internet().safeEmailAddress();
		cp.setEmail(email);

		cp.setPhoneNumber(faker.phoneNumber().phoneNumber());

		String password = faker.internet().password();
		cp.setPassword(password);
		cp.confirmPassword(password);
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("firstName", firstName);
		data.put("lastName", lastName);
		data.put("email", email);
		
		customerFileHandler.writeData(data);

	}

	@When("User clicks on save button")
	public void clickOnSaveButton() {		
		if (driver.getPageSource().contains("Warning: Please check the form carefully for errors!")) {
			driver.quit();
			Assert.assertTrue(false);
		} else {
			cp.clickSaveButton();
		}

	}

	@Then("User can see confirmation message {string}")
	public void checkConfirmationMessage(String message) {		
		Assert.assertTrue(driver.getPageSource().contains(message));
	}

	// Customer search with name

	@When("User enters fullname in Customer Name field")
	public void enterNameInCustomerSearchField() throws IOException {		
		cp.enterFullnameForFilter(getFullName());
	}

	@When("Clicks on filter button")
	public void clickOnFilterButton() {
		cp.pressFilterButton();
	}

	@Then("Customer name should be same as provided to filter the customer")
	public void checkIfCustomerAvailableUsingName() throws Exception {
		logger.info("*************** Checking Customer details using fullname **************");
		List<WebElement> rows = cp.getAllFilteredRows();
		
		Thread.sleep(2000);
		
		for(int i = 0; i < cp.getRowCount(); i++) {
			
			Thread.sleep(2000);
			WebElement targetCell = rows.get(i).findElements(By.tagName("td")).get(1);
			
			if(targetCell.getText().equals(getFullName())) {
				Thread.sleep(2000);
				Assert.assertEquals(getFullName(), targetCell.getText());		
				break;
			}else {
				Assert.assertTrue(false);
			}
		}
	}
	
	// Customer search with name
	
	@When("User enters email in the E-mail field")
	public void enterEmailInEmailSearchField() throws IOException {
		cp.enterEmailForFilter(customerFileHandler.readProperty("email"));
	}
	
	@Then("Customer email should be same as email provided to filter the customer")
	public void checkIfCustomerAvailableUsingEmail() throws IOException, Exception {
		logger.info("*************** Checking Customer details using email **************");

		String expectedEmail = customerFileHandler.readProperty("email");
		
		List<WebElement> rows = cp.getAllFilteredRows();
		
		Thread.sleep(2000);
		
		for(int i = 0; i < cp.getRowCount(); i++) {
			
			Thread.sleep(2000);
			WebElement targetCell = rows.get(i).findElements(By.tagName("td")).get(2);
			
			if(targetCell.getText().equals(expectedEmail)) {
				Thread.sleep(2000);
				Assert.assertEquals(expectedEmail, targetCell.getText());
				
				break;
			}else {
				Assert.assertTrue(false);
			}
		}
	}
	
	
	//Customer deletion
	
	@When("User selects the customer to be deleted")
	public void user_selects_the_customer_to_be_deleted() throws Exception {
		//filtering the customer using email
		String expectedEmail = customerFileHandler.readProperty("email");
		
		cp.enterEmailForFilter(expectedEmail);
		Thread.sleep(1000);
		
		cp.pressFilterButton();
		Thread.sleep(2000);
	
		List<WebElement> rows = cp.getAllFilteredRows();
		for(int i = 0; i < cp.getRowCount(); i++) {
			String actualEmail = rows.get(i).findElements(By.tagName("td")).get(2).getText();
			
			if(actualEmail.equals(expectedEmail)) {
				WebElement targetCell = rows.get(i).findElements(By.tagName("td")).get(0);
				targetCell.findElement(By.tagName("input")).click();
				
				break;
			}
		}
	}
	
	@And("Click on delete button")
	public void click_on_delete_button() throws Exception {
		cp.clickOnDeleteCustomerButton();
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		customerFileHandler.deleteData("firstName");
		customerFileHandler.deleteData("lastName");
		customerFileHandler.deleteData("email");
	}
	
	@And("User should be deleted from the list of Customers")
	public void user_should_be_deleted_from_the_list_of_customers() {
	  String text = cp.getAllFilteredRows().get(0).findElement(By.tagName("td")).getText();
	  
	  Assert.assertEquals("No results!", text);
	}
}
