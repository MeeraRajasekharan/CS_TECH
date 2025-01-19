import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomPages.AgentPage;
import PomPages.BaseClass;
import PomPages.CSVUploadPage;
import PomPages.LoginPage;

public class FullSetupTest extends BaseClass {

	LoginPage loginPage;
	AgentPage agentPage;
	CSVUploadPage csvUploadPage;

	@BeforeMethod
	public void setUp() throws Throwable {
		setup();
		loginPage = new LoginPage(driver);
		agentPage = new AgentPage(driver);
		csvUploadPage = new CSVUploadPage(driver);
	}

	@Test
	public void testFullSetup() throws Throwable {
	
		String email = pro.getProperty("Email");
		String password = pro.getProperty("Password");
		String agentName = pro.getProperty("Agent_Name");
		String agentMobile = pro.getProperty("Agent_Mobile");
		String agentEmail = pro.getProperty("Agent_Email");
		String agentPass = pro.getProperty("Agent_Pass");
		String filePath = "C:\\Users\\hrish\\Downloads\\Sample File.csv";

		// Step 1: Login
		loginPage.login(email, password);

		// Step 2: Navigate to agent creation and create agent
		WebElement teamTopLink = driver.findElement(By.xpath("//a[@class='team_top']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(teamTopLink).perform();
		driver.findElement(By.xpath("//*[@id='nav']/li[5]/ul/li[2]/a/span")).click();
		agentPage.createAgent(agentName, agentMobile, agentEmail, agentPass);

		// Step 3: Navigate to Call List and upload CSV
		WebElement callListLink = driver.findElement(By.linkText("Call List"));
		actions.moveToElement(callListLink).perform();
		driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li[1]/a/span")).click();
		csvUploadPage.uploadCSV("list numbers", filePath);

		// Step 4: Finalize upload
		csvUploadPage.finalizeUpload();
		Thread.sleep(2000); // Wait for the process to finish
	}

}
