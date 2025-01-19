package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	// Locators for the login page
	By emailField = By.id("txtEmailId");
	By passwordField = By.id("txtPassword");
	By submitButton = By.xpath("//input[@type='submit']");

	//  initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to login
	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(submitButton).click();
	}
}
