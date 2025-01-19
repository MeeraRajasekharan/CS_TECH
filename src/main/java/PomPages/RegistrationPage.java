package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {
	WebDriver driver;

	// Locators
	By nameField = By.id("txtName");
	By emailField = By.id("txtEmail");
	By passwordField = By.xpath("//input[@name='txtPassword']");
	By mobileField = By.xpath("//input[@name='txt_mobile']");
	By submitButton = By.xpath("//input[@type='submit']");
	By confirmButton = By.xpath("//button[@class='confirm']");
	By signUpButton = By.id("btnSignUp");
	By targetElement = By.xpath("/html/body/form/section[2]/div/div/div[3]/div[2]/div/a");
	By planButton = By.id("btnteamsplanactive");
	By newPlanButton = By.xpath("//a[@class='btn btn-new2 icon_right']");

	// Constructor to initialize driver
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to fill the registration form
	public void fillRegistrationForm(String name, String email, String password, String mobile) {
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(mobileField).sendKeys(mobile);
	}

	// Method to submit the registration form
	public void submitRegistration() {
		driver.findElement(submitButton).click();
		driver.findElement(confirmButton).click();
	}

	// Method to complete the signup and click necessary buttons
	public void completeSignup() {
		driver.findElement(signUpButton).click();
	}

	// Method to perform hover and click on target element
	public void hoverAndClickOnTarget() {
		WebElement targetElementWeb = driver.findElement(targetElement);
		Actions actions = new Actions(driver);
		actions.moveToElement(targetElementWeb).perform();
		targetElementWeb.click();
	}

	// Method to activate the plan
	public void activatePlan() {
		driver.findElement(planButton).click();
	}

	// Method to click on a new plan button
	public void clickNewPlan() {
		driver.findElement(newPlanButton).click();
	}
}
