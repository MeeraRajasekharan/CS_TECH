package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentPage {
	WebDriver driver;

	// Locators for the agent creation form
	By agentNameField = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txt_name']");
	By agentMobileField = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txt_mobile']");
	By agentEmailField = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txt_email']");
	By agentPassField = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txt_pass']");
	By submitButton = By.id("ContentPlaceHolder1_btn_submit");
	By confirmButton = By.xpath("//button[@class='confirm' and text()='OK']");

	// Constructor to initialize driver
	public AgentPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to create agent
	public void createAgent(String agentName, String agentMobile, String agentEmail, String agentPass) {
		driver.findElement(agentNameField).sendKeys(agentName);
		driver.findElement(agentMobileField).sendKeys(agentMobile);
		driver.findElement(agentEmailField).sendKeys(agentEmail);
		driver.findElement(agentPassField).sendKeys(agentPass);
		driver.findElement(submitButton).click();
		driver.findElement(confirmButton).click();
	}
}
