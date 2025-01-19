import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomPages.BaseClass;
import PomPages.RegistrationPage;

public class RegistrationTest extends BaseClass {

	RegistrationPage registrationPage;

	@BeforeMethod
	public void setUp() throws Throwable {
		setup(); // Setup WebDriver
		registrationPage = new RegistrationPage(driver); // Initialize the RegistrationPage
	}

	@Test
	public void testRegistration() throws InterruptedException {
		// Fetch data from properties file
		String name = pro.getProperty("Name");
		String email = pro.getProperty("Email");
		String password = pro.getProperty("Password");
		String mobile = pro.getProperty("Mobile");

		// Fill and submit registration form
		registrationPage.fillRegistrationForm(name, email, password, mobile);
		Thread.sleep(25000);
		registrationPage.submitRegistration();

		// Complete the sign-up and activate the plan
		Thread.sleep(20000);
		registrationPage.completeSignup();
		registrationPage.hoverAndClickOnTarget();
		registrationPage.activatePlan();
		registrationPage.clickNewPlan();

	
		Thread.sleep(3000); 
	}

	
}
