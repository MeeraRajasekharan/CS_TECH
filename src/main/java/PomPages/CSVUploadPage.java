package PomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CSVUploadPage {
	WebDriver driver;

	// Locators for the CSV upload page
	By listNameField = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtlistname']");
	By dropdown1 = By.id("ddlbelongto_1");
	By dropdown2 = By.id("ddlbelongto_2");
	By dropdown3 = By.id("ddlbelongto_3");
	By dropdownButton = By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']"); 
	By allCheckbox = By.xpath("//input[@value='all']");
	By fileUploadField = By.id("ContentPlaceHolder1_fileUpload");
	By uploadButton = By.id("ContentPlaceHolder1_btnUpload");
	By confirmButton = By.xpath("//button[@class='confirm']");

	// Constructor to initialize driver
	public CSVUploadPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to upload CSV file
	public void uploadCSV(String listName, String filePath) throws Throwable {
		driver.findElement(listNameField).sendKeys(listName);
		WebElement dropdown = driver.findElement(dropdownButton);
		dropdown.click();
		driver.findElement(allCheckbox).click(); // Select 'all' option
		driver.findElement(fileUploadField).sendKeys(filePath);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class=\"btn btn-new2\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='confirm']")).click();
		Thread.sleep(2000);
		// Select options from dropdowns
		new Select(driver.findElement(dropdown1)).selectByVisibleText("FirstName");
		new Select(driver.findElement(dropdown2)).selectByVisibleText("Phone");
		new Select(driver.findElement(dropdown3)).selectByVisibleText("Notes");
	}


	public void finalizeUpload() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement targetElement = driver.findElement(By.xpath("//input[@id=\"ContentPlaceHolder1_btnUpload\"]"));
		targetElement.click();
		driver.findElement(By.xpath("//button[@class=\"confirm\"]")).click();
		Thread.sleep(1000);
		driver.close();
	}
}
