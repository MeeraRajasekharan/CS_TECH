package PomPages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	protected WebDriver driver;
	protected Properties pro;

	public void setup() throws Throwable {
		// Load properties file
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\data.properties");
		pro = new Properties();
		pro.load(pfis);

		String browser = pro.getProperty("Browser");
		// Set up WebDriver based on browser property
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// WebDriver setup
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(pro.getProperty("Reg_Url"));
		driver.get(pro.getProperty("Login_Url"));
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}