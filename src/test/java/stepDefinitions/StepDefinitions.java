package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class StepDefinitions extends BaseClass {

	String firstName;
	String lastName;
	String email;

	@Given("User launches the chrome browser")
	public void launchChromeBrowser() {
		setup();
		initializePageObjects();
	}

	@And("User opens OpenCart Ecommerce - Admin Application using {string}")
	public void launch_OpenCart_AdminApplication(String url) throws Exception {
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
		lp.clickLoginBtn();
		Thread.sleep(3000);
	}

	@Then("Title of the page should be {string}")
	public void checkTitleOfPage(String title) {

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
		dp.clickOnLogoutBtn();
		Thread.sleep(3000);
	}

	@And("Close the browser")
	public void closeBrowser() {
		driver.quit();
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
	public void user_enters_new_customer_details() {
		firstName = faker.name().firstName();
		cp.setFirstname(firstName);

		lastName = faker.name().lastName();
		cp.setLastname(lastName);

		email = faker.internet().safeEmailAddress();
		cp.setEmail(email);

		cp.setPhoneNumber(faker.phoneNumber().phoneNumber());

		String password = faker.internet().password();
		cp.setPassword(password);
		cp.confirmPassword(password);

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
	public void enterNameInCustomerSearchField() {
		cp.enterFullnameForFilter(firstName);
	}

	@When("Clicks on filter button")
	public void clickOnFilterButton() {
		cp.pressFilterButton();
	}

	@Then("Customer should be available in customer details table.")
	public void checkCustomerDetialsInTable() {
		
	}
}
