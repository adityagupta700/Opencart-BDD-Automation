package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class LoginAndLogut_StepDefinition extends BaseClass {

	LoginPage lp;
	DashboardPage dp;
	
	@Given("User launches the chrome browser")
	public void launchChromeBrowser() {
		BaseClass.setup();
	}

	@And("User opens OpenCart Ecommerce - Admin Application using {string}")
	public void launch_OpenCart_AdminApplication(String url) throws Exception {
		driver.get(url);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
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
		
		if (driver.getPageSource().contains("No match for Username and/or Password.")) {
			driver.quit();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(driver.getTitle(), title);
		}
		
		if(driver.getTitle().equals("Administration")) {
			driver.quit();
		}

	}
	
	@When("User clicks on logout button")
	public void clickOnLogoutButton() throws Exception {
		dp = new DashboardPage(driver);
		dp.clickOnLogoutBtn();
		Thread.sleep(3000);
	}
}
